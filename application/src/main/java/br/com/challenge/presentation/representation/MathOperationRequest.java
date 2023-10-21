package br.com.challenge.presentation.representation;

import br.com.challenge.enums.OperationTypeEnum;

import javax.validation.constraints.NotNull;

public record MathOperationRequest(
    @NotNull(message = "User id must be informed") Long userId,
    @NotNull(message = "Operation type must be informed") OperationTypeEnum operationType,
    @NotNull(message = "Operand1 must be informed") Double operand1,
    @NotNull(message = "Operand2 must be informed") Double operand2
) {}
