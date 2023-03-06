package org.roronoa.banklyoperation.service;

import org.roronoa.banklyoperation.entity.Operation;

import java.io.IOException;
import java.util.List;

public interface IOperationService {
    Operation save(Operation operation);
    Operation getOperation(String id);
    List<Operation> getAllOperationWallet(String wallet);

}
