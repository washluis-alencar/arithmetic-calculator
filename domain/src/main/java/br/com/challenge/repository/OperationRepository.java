package br.com.challenge.repository;

import br.com.challenge.domain.Operation;
import br.com.challenge.enums.OperationTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Optional<Operation> findByType(OperationTypeEnum type);

}
