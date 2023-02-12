package org.roronoa.banklyoperation.repository;

import org.roronoa.banklyoperation.entity.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperationRepository extends MongoRepository<Operation, String> {

}
