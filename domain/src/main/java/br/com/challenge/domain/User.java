package br.com.challenge.domain;

import br.com.challenge.enums.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USER_INFO")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private StatusEnum status;

    @Column(name = "initial_balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal initialBalance;
}
