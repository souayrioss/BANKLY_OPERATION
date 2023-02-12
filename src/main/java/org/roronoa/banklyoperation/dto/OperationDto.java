package org.roronoa.banklyoperation.dto;

import lombok.Data;
import java.util.Date;
@Data
public class OperationDto{
    private String id;
    private String wallet;
    private String typeOperation;
    private Date dateOperation;
    private Double sold;
}
