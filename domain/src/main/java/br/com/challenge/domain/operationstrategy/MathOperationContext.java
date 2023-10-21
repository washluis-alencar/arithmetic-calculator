package br.com.challenge.domain.operationstrategy;

import br.com.challenge.domain.MathOperation;
import br.com.challenge.enums.OperationTypeEnum;

/**
 * Class that defines the context for the math operations.
 */
public class MathOperationContext {
    private MathOperationStrategy strategy;

    public MathOperationContext(OperationTypeEnum operationType) {
        switch (operationType) {
            case ADDITION:
                strategy = new AdditionOperation();
                break;
            case SUBTRACTION:
                strategy = new SubtractionOperation();
                break;
            case MULTIPLICATION:
                strategy = new MultiplicationOperation();
                break;
            case DIVISION:
                strategy = new DivisionOperation();
                break;
            case SQUARE_ROOT:
                strategy = new SquareRootOperation();
                break;
            case RANDOM_STRING:
                strategy = new RandomStringOperation();
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation type");
        }
    }

    public void executeOperation(MathOperation mathOperation) {
        strategy.execute(mathOperation);
    }
}
