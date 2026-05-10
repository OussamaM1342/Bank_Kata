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

    //Deposits the given amount into the account.
    public void deposit(BigDecimal amount){
        balance = balance.add(amount) ; 
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    //Returns an immutable list of all transactions.
    public List<Transaction> getTransactions(){
        return List.copyOf(transactions) ;
    }

}
