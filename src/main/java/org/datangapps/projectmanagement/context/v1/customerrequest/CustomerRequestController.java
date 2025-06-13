package org.datangapps.projectmanagement.context.v1.customerrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer-request")
public class CustomerRequestController {

	@Autowired
	private CustomerRequestService customerRequestService;
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody CustomerRequestReqModel customerRequestReqModel) {
		
        ResponseEntity<Object> responseEntity = null;

        try {
        
            var responseModel = this.customerRequestService.addNewCustomer(customerRequestReqModel);
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
