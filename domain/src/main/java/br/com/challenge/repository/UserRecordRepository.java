package br.com.challenge.repository;

import br.com.challenge.domain.UserRecord;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {

    List<UserRecord> findAllByUserId(Long userId, PageRequest pageRequest);

    Optional<UserRecord> findFirstByUserIdOrderByDateDesc(Long userId);
}
