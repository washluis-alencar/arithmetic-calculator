package br.com.challenge.domain.operationstrategy;

import br.com.challenge.domain.MathOperation;

/**
 * Class that implements the division operation
 */
public class DivisionOperation implements MathOperationStrategy {

    @Override
    public void execute(MathOperation mathOperation) {
        if (mathOperation.getOperand1() == null || mathOperation.getOperand2() == null) {
            throw new IllegalArgumentException("Both operands must be provided");
        }
        if (mathOperation.getOperand2() == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        mathOperation.setResult(String.valueOf(mathOperation.getOperand1() / mathOperation.getOperand2()));
    }
}
