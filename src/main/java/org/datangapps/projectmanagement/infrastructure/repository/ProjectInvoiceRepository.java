package org.datangapps.projectmanagement.infrastructure.repository;

import java.util.UUID;
import org.datangapps.projectmanagement.infrastructure.entity.ProjectInvoiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectInvoiceRepository extends CrudRepository<ProjectInvoiceEntity, UUID> {

}
