package org.roronoa.banklyoperation.util;


import org.modelmapper.ModelMapper;
import org.roronoa.banklyoperation.dto.OperationDto;
import org.roronoa.banklyoperation.entity.Operation;

public class EntityUtils {

    public static OperationDto operationToOperationDTO(Operation operation) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(operation, OperationDto.class);
    }
    public static Operation operationDTOToOperation(OperationDto operationDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(operationDto, Operation.class);
    }


}
