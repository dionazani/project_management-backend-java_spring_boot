package org.datangapps.projectmanagement.context.v1.customerrequest;

import lombok.Data;

@Data
public class CustomerRequestReqModel {

	private String employeeId;
	private String customerName;
	private String mobilePhone;
	private String gender;
	private String email;
	private String createdBy;
}
