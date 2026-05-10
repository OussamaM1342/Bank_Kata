package com.bank.kata.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.kata.model.BankAccount;
import com.bank.kata.model.Transaction;

@Service
public class BankAccountService {
    
    private final BankAccount account = new BankAccount();

    // Deposits the given amount into the account.
    public void deposit(BigDecimal amount) {
        account.deposit(amount);
    }

    // Withdraws the given amount from the account.
    public void withdraw(BigDecimal amount) {
        account.withdraw(amount);
    }

    //Returns the list of all transactions.
    public List<Transaction> getStatement() {
        return account.getTransactions();
    }




}
