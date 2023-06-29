package br.com.escorpion.expensemanagerwebservicep1.api.budget.service.impl;

import br.com.escorpion.expensemanagerwebservicep1.api.budget.service.FinancialAccountService;
import br.com.escorpion.expensemanagerwebservicep1.shared.data.repositories.FinancialAccountRepository;
import br.com.escorpion.expensemanagerwebservicep1.shared.domain.entity.FinancialAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialAccountServiceImpl implements FinancialAccountService {
    private FinancialAccountRepository financialAccountRepository;

    @Autowired
    public FinancialAccountServiceImpl(FinancialAccountRepository financialAccountRepository) {
        this.financialAccountRepository = financialAccountRepository;
    }

    @Override
    public FinancialAccount createFinancialAccount(FinancialAccount financialAccount) {
        if (financialAccount != null) {
            return financialAccountRepository.save(financialAccount);
        }
        return null;
    }

    @Override
    public FinancialAccount updateFinancialAccount(Long id, FinancialAccount financialAccount) {
        financialAccountRepository.findById(id).map(record -> {
            record.setFinancialAccountName(financialAccount.getFinancialAccountName());
            record.setFinancialAccountValue(financialAccount.getFinancialAccountValue());
            record.setCategory(financialAccount.getCategory());
            return financialAccountRepository.save(record);
        });
        return null;
    }

    @Override
    public List<FinancialAccount> findAll() {
        return financialAccountRepository.findAll();
    }

    @Override
    public Optional<FinancialAccount> findById(Long id) {
        return financialAccountRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        financialAccountRepository.findById(id).map(record -> {
            financialAccountRepository.deleteById(id);
            return "ok";
        });
    }

    @Override
    public Double calculateTotalFinalAccount(List<FinancialAccount> financialAccounts) {
        return financialAccounts.stream().mapToDouble(FinancialAccount::getFinancialAccountValue).sum();
    }
}
