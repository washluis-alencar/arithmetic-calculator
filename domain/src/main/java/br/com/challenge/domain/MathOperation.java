package br.com.challenge.domain;

import br.com.challenge.enums.OperationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MathOperation {
    private Long userId;
    private OperationTypeEnum operationType;
    private Double operand1;
    private Double operand2;
    private String result;
    private BigDecimal cost;

    public MathOperation(Long userId, OperationTypeEnum operationType, Double operand1, Double operand2) {
        this.userId = userId;
        this.operationType = operationType;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
}
