package br.com.challenge.domain.operationstrategy;

import br.com.challenge.domain.MathOperation;

/**
 * Interface that defines the contract for the math operations.
 */
public interface MathOperationStrategy {
    void execute(MathOperation mathOperation);
}
