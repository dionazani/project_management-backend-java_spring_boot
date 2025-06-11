package org.datangapps.projectmanagement.context.v1.createinvoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/create-invoice")
public class CreateInvoiceController {

	@Autowired
	private CreateInvoiceService createInvoiceService;
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody CreateInvoiceReqModel projectInvoiceReqModel) {
		
        ResponseEntity<Object> responseEntity = null;

        try {
        
            var responseModel = this.createInvoiceService.createInvoice(projectInvoiceReqModel);
            responseEntity = ResponseEntity.status(responseModel.getHttpStatusCode())
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(responseModel);

        }
        catch(Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .contentType(MediaType.TEXT_PLAIN)
                                .body(ex.getMessage());
        }

        return responseEntity;
    }
}
