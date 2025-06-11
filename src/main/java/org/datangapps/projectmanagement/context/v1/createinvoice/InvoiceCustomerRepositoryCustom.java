package org.datangapps.projectmanagement.context.v1.createinvoice;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class InvoiceCustomerRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public InvoiceCustomerEntity getInvoiceByProjectId(String projectId) {
		
		String sql = "select project_invoice.id,\r\n"
				+ "		project_invoice.invoice_number,\r\n"
				+ "		customer.id as customer_id,\r\n"
				+ "		customer.email\r\n"
				+ "from project_invoice inner join project on project.id = project_invoice.project_id\r\n"
				+ "		inner join customer on customer.id = project.customer_id\r\n"
				+ "where project_invoice.project_id = :projectId";
		
		var invoiceCustomerEntity = (InvoiceCustomerEntity) this.em.createNativeQuery(sql, InvoiceCustomerEntity.class)
                .setParameter("projectId", projectId)
                .getSingleResult();
	
		return invoiceCustomerEntity;
	}
}
