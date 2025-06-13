package org.datangapps.projectmanagement.infrastructure.repository;

import java.util.UUID;
import org.datangapps.projectmanagement.infrastructure.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {

}
