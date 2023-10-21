package br.com.challenge.domain.operationstrategy;

import br.com.challenge.domain.MathOperation;

/**
 * Class that implements the random string operation.
 */
public class RandomStringOperation implements MathOperationStrategy {
    @Override
    public void execute(MathOperation mathOperation) {
        String randomString = generateRandomString();
        mathOperation.setResult(randomString);
    }

    private String generateRandomString() {
        return "RandomStringGenerated";
    }
}
