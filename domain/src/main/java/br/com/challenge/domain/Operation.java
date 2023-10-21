package br.com.challenge.domain;

import br.com.challenge.enums.OperationTypeEnum;
import br.com.challenge.enums.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "OPERATION")
@Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private OperationTypeEnum type;

    @Column(nullable = false)
    private BigDecimal cost;
}
