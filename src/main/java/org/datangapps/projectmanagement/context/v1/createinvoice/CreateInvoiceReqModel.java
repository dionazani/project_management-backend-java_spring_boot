package org.datangapps.projectmanagement.context.v1.createinvoice;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class CreateInvoiceReqModel {

    private String id;

    private String projectId;

    private String invoiceNumber;

    private String invoiceDate;

    private String notes;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String createdBy;

    private String updatedBy;
}
