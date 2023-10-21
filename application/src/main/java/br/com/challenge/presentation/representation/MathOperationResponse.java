package br.com.challenge.presentation.representation;

import java.math.BigDecimal;

public record MathOperationResponse(
    Long userId,
    Double operand1,
    Double operand2,
    String result,
    BigDecimal cost
) {
}
