package com.bank.kata.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.kata.model.Transaction;
import com.bank.kata.service.BankAccountService;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @Autowired
    private  BankAccountService accountService;

    /**
     * Deposits the given amount into the account.
     * POST /account/deposit/{amount}
     */
    @PostMapping("/deposit/{amount}")
    public ResponseEntity<Void> deposit(@PathVariable BigDecimal amount) {
        accountService.deposit(amount);
        return ResponseEntity.ok().build();
    }

    /**
     * Withdraws the given amount from the account.
     * POST /account/withdraw/{amount}
     */
    @PostMapping("/withdraw/{amount}")
    public ResponseEntity<Void> withdraw(@PathVariable BigDecimal amount) {
        accountService.withdraw(amount);
        return ResponseEntity.ok().build();
    }

    /**
     * Returns the statement with all transactions.
     * GET /account/statement
     */
    @GetMapping("/statement")
    public ResponseEntity<List<Transaction>> statement() {
        return ResponseEntity.ok(accountService.getStatement());
    }


}
