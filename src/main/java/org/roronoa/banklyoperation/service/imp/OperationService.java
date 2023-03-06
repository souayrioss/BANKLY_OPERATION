package org.roronoa.banklyoperation.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.roronoa.banklyoperation.dto.ResponseDTO;
import org.roronoa.banklyoperation.entity.Operation;
import org.roronoa.banklyoperation.entity.TypeOperation;
import org.roronoa.banklyoperation.repository.OperationRepository;
import org.roronoa.banklyoperation.service.IOperationService;
import org.roronoa.banklyoperation.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
@Service
public class OperationService implements IOperationService {

    @Autowired
    OperationRepository operationRepository;
    @Autowired
    IWalletService walletService;

    @Override
    public Operation save(@Valid Operation operation){

        Double sold = getWallet(operation.getWallet());
        if (operation.getTypeOperation().equals(TypeOperation.WITHDRAW)){
            if (!validationSold(sold,operation.getSold())) {
                return null;
            }
            sold = sold - operation.getSold();
        } else if (operation.getTypeOperation().equals(TypeOperation.DEPOSIT)) {
            sold = sold + operation.getSold();
        }
        operation.setDateOperation(LocalDate.now());
        if (checkUpdate(operation.getWallet(),sold)) {
            return operationRepository.save(operation);
        }
        return null;
    }

    @Override
    public Operation getOperation(String id) {
        return null;
    }

    @Override
    public List<Operation> getAllOperationWallet(String wallet) {
        return Collections.emptyList();
    }

    public Double getWallet(String reference){
        ResponseDTO<Double> response = walletService.getSoldWallet(reference);
        return response.getData();
    }
    public boolean checkUpdate(String reference,Double sold){
        return walletService.update(reference,sold).getData();
    }
    public boolean validationSold(Double soldWallet,Double soldOperation){
        return soldWallet >= soldOperation;
    }


}
