package org.datangapps.projectmanagement.context.v1.createinvoice;

import java.text.ParseException;
import java.util.UUID;

import org.datangapps.projectmanagement.infrastructure.entity.ProjectInvoiceEntity;
import org.datangapps.projectmanagement.infrastructure.model.ResponseModel;
import org.datangapps.projectmanagement.infrastructure.repository.ProjectInvoiceRepository;
import org.datangapps.projectmanagement.utils.common.FormatUtils;
import org.datangapps.projectmanagement.utils.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateInvoiceServiceImpl implements CreateInvoiceService {

	@Autowired
	private ProjectInvoiceRepository projectInvoiceRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public ResponseModel createInvoice(CreateInvoiceReqModel projectInvoiceReqModel) {
		
		var responseModel = new ResponseModel();
		
		try {
			
			java.util.Date utilInvoiceDate = FormatUtils.getDateFromString(projectInvoiceReqModel.getInvoiceDate());
			java.sql.Date sqlInvoiceDate = new java.sql.Date(utilInvoiceDate.getTime());
			
			var projectInvoiceEntity = new ProjectInvoiceEntity();
			projectInvoiceEntity.setProjectId(UUID.fromString(projectInvoiceReqModel.getProjectId()));
			projectInvoiceEntity.setInvoiceNumber(projectInvoiceReqModel.getInvoiceNumber());
			projectInvoiceEntity.setInvoiceDate(sqlInvoiceDate);
			projectInvoiceEntity.setNotes(projectInvoiceReqModel.getNotes());
			projectInvoiceEntity.setCreatedBy(UUID.fromString(projectInvoiceReqModel.getCreatedBy()));
			projectInvoiceRepository.save(projectInvoiceEntity);
			
			emailService.sendEmail("budi.santoso@gmail.com", "Invoice Pelatihan", "Selamat malam Bapak/Ibu, berikut kami kirimkan Invoice untuk Pelatihan");
			
			responseModel = new ResponseModel();
			responseModel.setHttpStatusCode(200);
			responseModel.setResponseCode("000");
	        responseModel.setResponseMessage("succes");
	        responseModel.setTimeStamp(FormatUtils.getCurrentTimestamp());
	        responseModel.setData(null);
	        
		}
		catch(ParseException pex) {
			pex.printStackTrace();
		}
		
		
		return responseModel;
	}

}
