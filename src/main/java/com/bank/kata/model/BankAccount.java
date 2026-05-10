package com.bank.kata.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all banking operations and maintains transaction history.
 */
public class BankAccount {

    private BigDecimal balance = BigDecimal.ZERO ;
    private final List<Transaction> transactions = new ArrayList<>() ;

    // Deposits the given amount into the account.
    public void deposit(BigDecimal amount){
        balance = balance.add(amount) ; 
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    //  Withdraws the specified amount from the account.
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) throw new IllegalArgumentException("Insufficient funds");
        balance = balance.subtract(amount) ;
        transactions.add(new Transaction(LocalDate.now(), amount.negate(), balance));
    }

    //Returns an immutable list of all transactions.
    public List<Transaction> getTransactions(){
        return List.copyOf(transactions) ;
    }

}
