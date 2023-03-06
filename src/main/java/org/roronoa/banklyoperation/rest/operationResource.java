package org.roronoa.banklyoperation.rest;

import lombok.RequiredArgsConstructor;
import org.roronoa.banklyoperation.dto.OperationDto;
import org.roronoa.banklyoperation.dto.ResponseDTO;
import org.roronoa.banklyoperation.entity.Operation;
import org.roronoa.banklyoperation.service.IOperationService;
import org.roronoa.banklyoperation.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.roronoa.banklyoperation.util.IConstantes.*;

@RestController
@RequestMapping("/api/v1/operations")
@RequiredArgsConstructor
public class operationResource {

    @Autowired
    IOperationService operationService;


    @PostMapping("/save")
    public ResponseDTO<OperationDto> save(@RequestBody OperationDto operationDto){
        try{
            Operation operation =EntityUtils.operationDTOToOperation(operationDto);
            operation = operationService.save(operation);
            ResponseDTO response = new ResponseDTO<>();
            response.setData(EntityUtils.operationToOperationDTO(operation));
            response.setStatus(CODE_001);
            return response;
        }catch (Exception e){
            ResponseDTO response = new ResponseDTO<>();
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @GetMapping
    public ResponseDTO<OperationDto> getAllOperations(){
        try{
            Operation operation = operationService.getAllOperationWallet();
            ResponseDTO response = new ResponseDTO<>();
            response.setData(EntityUtils.operationToOperationDTO(operation));
            response.setStatus(CODE_001);
            return response;
        }catch (Exception e){
            ResponseDTO response = new ResponseDTO<>();
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return response;
        }
    }
}
