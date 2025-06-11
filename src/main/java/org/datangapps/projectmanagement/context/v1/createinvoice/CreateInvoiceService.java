package org.datangapps.projectmanagement.context.v1.createinvoice;

import org.datangapps.projectmanagement.infrastructure.model.ResponseModel;

public interface CreateInvoiceService {

	ResponseModel createInvoice(CreateInvoiceReqModel projectInvoiceReqModel);
}
