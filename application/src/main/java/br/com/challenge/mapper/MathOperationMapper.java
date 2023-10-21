package br.com.challenge.mapper;

import br.com.challenge.domain.MathOperation;
import br.com.challenge.presentation.representation.MathOperationRequest;
import br.com.challenge.presentation.representation.MathOperationResponse;

public class MathOperationMapper {
    public static MathOperation toDomain(MathOperationRequest request) {
        return new MathOperation(
            request.userId(),
            request.operationType(),
            request.operand1(),
            request.operand2()
        );
    }

    public static MathOperationResponse toResponse(MathOperation mathOperation) {
        return new MathOperationResponse(
            mathOperation.getUserId(),
            mathOperation.getOperand1(),
            mathOperation.getOperand2(),
            mathOperation.getResult(),
            mathOperation.getCost()
        );
    }
}
