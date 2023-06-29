package br.com.escorpion.expensemanagerwebservicep1.api.budget.resource;

import br.com.escorpion.expensemanagerwebservicep1.shared.domain.entity.FinancialAccount;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping(path = "/financialAccount")
public interface FinancialAccountResource {

    @PostMapping
    ResponseEntity<?> createFinancialAccount(@RequestBody FinancialAccount financialAccount);

    @PutMapping
    ResponseEntity<?> updateFinancialAccount(@RequestParam Long id, @RequestBody FinancialAccount financialAccount);

    @GetMapping
    ResponseEntity<?> listAllFinancialAccounts();

    @GetMapping(path = {"/{id}"})
    ResponseEntity<?> findById(@PathVariable("id") Long id);

    @DeleteMapping(path = {"/{id}"})
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @GetMapping(path = "/totalFinancialAccount")
    ResponseEntity<?> calculateTotalFinalAccount();
}
