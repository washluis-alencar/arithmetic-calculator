package br.com.challenge.service.impl;

import br.com.challenge.domain.MathOperation;
import br.com.challenge.domain.Operation;
import br.com.challenge.domain.User;
import br.com.challenge.domain.UserRecord;
import br.com.challenge.domain.operationstrategy.MathOperationContext;
import br.com.challenge.exception.ServiceException;
import br.com.challenge.repository.OperationRepository;
import br.com.challenge.repository.UserRecordRepository;
import br.com.challenge.repository.UserRepository;
import br.com.challenge.service.UserOperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class UserOperationServiceImpl implements UserOperationService {
    private final UserRecordRepository userRecordRepository;
    private final OperationRepository operationRepository;
    private final UserRepository userRepository;

    public UserOperationServiceImpl(UserRecordRepository userRecordRepository,
                                    OperationRepository operationRepository,
                                    UserRepository userRepository) {
        this.userRecordRepository = userRecordRepository;
        this.operationRepository = operationRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public MathOperation execMathOperation(MathOperation mathOperation) {
        var user = userRepository.findById(mathOperation.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        var operation = operationRepository.findByType(mathOperation.getOperationType())
                .orElseThrow(() -> new EntityNotFoundException("Operation not found"));

        var operationContext = new MathOperationContext(mathOperation.getOperationType());
        operationContext.executeOperation(mathOperation);

        mathOperation.setCost(operation.getCost());

        BigDecimal userBalance = validateAndGetUserBalance(user, operation);
        saveUserRecord(mathOperation, user, operation, userBalance);

        return mathOperation;
    }

    private BigDecimal validateAndGetUserBalance(User user, Operation operation) {
        var lastUserRecord = userRecordRepository.findFirstByUserIdOrderByDateDesc(user.getId());
        var userBalance = lastUserRecord.map(UserRecord::getUserBalance).orElse(user.getInitialBalance());

        if (userBalance.compareTo(operation.getCost()) < 0) {
            throw new ServiceException("User has no balance to execute this operation");
        }
        return userBalance;
    }

    private void saveUserRecord(MathOperation mathOperation, User user, Operation operation, BigDecimal userBalance) {
        UserRecord userRecord = new UserRecord(operation, user);
        userRecord.setAmount(operation.getCost());
        userRecord.setUserBalance(userBalance.subtract(operation.getCost()));
        userRecord.setOperationResponse(mathOperation.getResult());
        userRecord.setDate(LocalDate.now());
        userRecordRepository.save(userRecord);
    }
}
