package br.com.escorpion.expensemanagerwebservicep1.api.budget.service;

import br.com.escorpion.expensemanagerwebservicep1.shared.domain.entity.FinancialAccount;

import java.util.List;
import java.util.Optional;

public interface FinancialAccountService {

    FinancialAccount createFinancialAccount(FinancialAccount financialAccount);

    FinancialAccount updateFinancialAccount(Long id, FinancialAccount financialAccount);

    List<FinancialAccount> findAll();

    Optional<FinancialAccount> findById(Long id);

    void delete(Long id);

    Double calculateTotalFinalAccount(List<FinancialAccount> financialAccounts);

}
