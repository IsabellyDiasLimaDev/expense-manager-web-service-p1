package br.com.escorpion.expensemanagerwebservicep1.shared.data.repositories;

import br.com.escorpion.expensemanagerwebservicep1.shared.domain.entity.FinancialAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialAccountRepository extends JpaRepository<FinancialAccount, Long> {
}
