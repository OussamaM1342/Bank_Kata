package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.bank.kata.model.BankAccount;

@SpringBootTest
class KataApplicationTests {

	private BankAccount account;  

	@BeforeEach
	void setUp(){
		account = new BankAccount(); 

	}

	// Given a bank account
	// When a deposit is made 
	// Then the balance should be updated
	@Test
	void deposit_adds_to_balance(){
		account.deposit(new BigDecimal("1000"));
		assertEquals(new BigDecimal("1000"), account.getTransactions().get(0).balance());
	}

	// Given a bank account
	// When a deposit is made 
	// Then the transaction should be recorded
	@Test
	void deposit_records_transaction(){
		account.deposit(new BigDecimal("1000")); 
		assertEquals(1, account.getTransactions().size());
		assertEquals(new BigDecimal("1000"), account.getTransactions().get(0).amount());
	}

	// Given a bank account with a balance of 1000
    // When a withdrawal of 300 is made
    // Then the balance should be 700
	@Test
    void withdrawal_update_balance() {
		account.deposit(new BigDecimal("1000")); 
        account.withdraw(new BigDecimal("300"));
        assertEquals(new BigDecimal("700") , account.getTransactions().get(1).balance());
    }

	// Given a bank account with a balance of 1000
    // When a withdrawal of 300 is made
    // Then the transaction should be recorded as -300
    @Test
    void withdrawal_records_negative_amount() {
		account.deposit(new BigDecimal("1000")); 
        account.withdraw(new BigDecimal("300"));
        assertEquals(new BigDecimal("-300") , account.getTransactions().get(1).amount());
    }

	//Tests that a withdrawal with insufficient funds throws an exception.
	@Test
    void withdrawal_with_insufficient_funds_throws_exception() {
		account.deposit(new BigDecimal("500")); 
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(new BigDecimal(1000) ));
    }
}
