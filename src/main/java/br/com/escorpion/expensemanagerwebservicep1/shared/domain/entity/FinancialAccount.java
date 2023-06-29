package br.com.escorpion.expensemanagerwebservicep1.shared.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_financial_account")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinancialAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "financial_account_name")
    private String financialAccountName;

    @Column(length = 150)
    private String category;

    @Column(name = "financial_account_value")
    private Double financialAccountValue;
}
