package org.datangapps.projectmanagement.context.v1.createinvoice;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class InvoiceCustomerEntity {

	@Id
	private UUID id;
	
	private String invoiceNumber;
	
	private UUID customerId;
	
	private String email;
}
