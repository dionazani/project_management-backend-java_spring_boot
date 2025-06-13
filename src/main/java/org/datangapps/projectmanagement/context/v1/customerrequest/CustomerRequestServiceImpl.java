package org.datangapps.projectmanagement.context.v1.customerrequest;

import java.util.UUID;

import org.datangapps.projectmanagement.infrastructure.entity.CustomerEntity;
import org.datangapps.projectmanagement.infrastructure.model.ResponseModel;
import org.datangapps.projectmanagement.infrastructure.repository.CustomerRepository;
import org.datangapps.projectmanagement.utils.common.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRequestServiceImpl implements CustomerRequestService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ResponseModel addNewCustomer(CustomerRequestReqModel customerRequestModel) {
		
		ResponseModel responseModel = null;
		
		var customerEntity = new CustomerEntity();
		customerEntity.setEmployeeId(UUID.fromString(customerRequestModel.getEmployeeId()));
		customerEntity.setCustomerName(customerRequestModel.getCustomerName());
		customerEntity.setMobilePhone(customerRequestModel.getCustomerName());
		customerEntity.setGender(customerRequestModel.getGender());
		customerEntity.setEmail(customerRequestModel.getEmail());
		customerEntity.setCreatedBy(UUID.fromString(customerRequestModel.getCreatedBy()));
		customerRepository.save(customerEntity);
		
		responseModel = new ResponseModel();
		responseModel.setHttpStatusCode(200);
		responseModel.setResponseCode("000");
        responseModel.setResponseMessage("succes");
        responseModel.setTimeStamp(FormatUtils.getCurrentTimestamp());
        responseModel.setData(null);
		
		return responseModel;
	}
	
}
