package br.com.challenge.domain.operationstrategy;

import br.com.challenge.domain.MathOperation;

/**
 * Class that implements the multiplication operation.
 */
public class MultiplicationOperation implements MathOperationStrategy {

    @Override
    public void execute(MathOperation mathOperation) {
        if (mathOperation.getOperand1() == null || mathOperation.getOperand2() == null) {
            throw new IllegalArgumentException("Both operands must be provided");
        }
        mathOperation.setResult(String.valueOf(mathOperation.getOperand1() * mathOperation.getOperand2()));
    }
}
