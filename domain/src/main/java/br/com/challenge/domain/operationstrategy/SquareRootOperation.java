package br.com.challenge.domain.operationstrategy;

import br.com.challenge.domain.MathOperation;

/**
 * Class that implements the square root operation.
 */
public class SquareRootOperation implements MathOperationStrategy {

    @Override
    public void execute(MathOperation mathOperation) {
        if (mathOperation.getOperand1() == null || mathOperation.getOperand1() < 0) {
            throw new IllegalArgumentException("Operand must be provided and non-negative for square root");
        }
        mathOperation.setResult(String.valueOf(Math.sqrt(mathOperation.getOperand1())));
    }
}
