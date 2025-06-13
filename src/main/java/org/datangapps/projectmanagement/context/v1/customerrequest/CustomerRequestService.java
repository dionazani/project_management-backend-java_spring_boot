package org.datangapps.projectmanagement.context.v1.customerrequest;

import org.datangapps.projectmanagement.infrastructure.model.ResponseModel;

public interface CustomerRequestService {

	ResponseModel addNewCustomer(CustomerRequestReqModel customerRequestModel);
}
