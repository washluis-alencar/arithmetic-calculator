package br.com.challenge.presentation;

import br.com.challenge.mapper.MathOperationMapper;
import br.com.challenge.presentation.representation.MathOperationRequest;
import br.com.challenge.presentation.representation.MathOperationResponse;
import br.com.challenge.service.UserOperationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiV1Path.MATH_OPERATION)
public class MathOperationController {

    private final UserOperationService userOperationService;

    public MathOperationController(UserOperationService userOperationService) {
        this.userOperationService = userOperationService;
    }

    @PostMapping
    public MathOperationResponse execMathOperation(@RequestBody MathOperationRequest request) {
        var result = userOperationService.execMathOperation(MathOperationMapper.toDomain(request));
        return MathOperationMapper.toResponse(result);
    }

}

