package br.com.escorpion.expensemanagerwebservicep1.api.budget.controller;

import br.com.escorpion.expensemanagerwebservicep1.api.budget.resource.FinancialAccountResource;
import br.com.escorpion.expensemanagerwebservicep1.api.budget.service.FinancialAccountService;
import br.com.escorpion.expensemanagerwebservicep1.shared.domain.entity.FinancialAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class FinancialAccountController implements FinancialAccountResource {

    private FinancialAccountService financialAccountService;

    @Autowired
    public FinancialAccountController(FinancialAccountService financialAccountService) {
        this.financialAccountService = financialAccountService;
    }

    @Override
    public ResponseEntity<?> listAllFinancialAccounts() {
        return ResponseEntity.ok(financialAccountService.findAll());
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<FinancialAccount> financialAccount = financialAccountService.findById(id);
        if (financialAccount.isPresent()) {
            return ResponseEntity.ok(financialAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        try {
            financialAccountService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> createFinancialAccount(FinancialAccount financialAccount) {
        var financialAccountCreated = financialAccountService.createFinancialAccount(financialAccount);
        if (financialAccountCreated != null) {
            return ResponseEntity.ok().body(financialAccountCreated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> updateFinancialAccount(Long id, FinancialAccount financialAccount) {
        var financialAccountUpdated = financialAccountService.updateFinancialAccount(id, financialAccount);
        if (financialAccountUpdated != null) {
            return ResponseEntity.ok().body(financialAccountUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> calculateTotalFinalAccount() {
        List<FinancialAccount> financialAccounts = financialAccountService.findAll();
        return ResponseEntity.ok(financialAccountService.calculateTotalFinalAccount(financialAccounts));
    }
}
