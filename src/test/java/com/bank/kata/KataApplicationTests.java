package com.bank.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KataApplicationTests {

	@BeforeEach
	void setUp(){
		account = new BankAccount(); 

	}

	// Given a bank account
	// When a deposit is made 
	// Then the balance should be updated
	@Test
	void deposit_adds_to_balance(){
		account.deposit(1000);
		assertEquals(1000, account.getTransactions().get(0).balance());
	}

	// Given a bank account
	// When a deposit is made 
	// Then the transaction should be recorded
	@Test
	void deposit_records_transaction(){
		account.deposit(1000); 
		assertEquals(1, account.getTransactions().size());
		assertEquals(1000, account.getTransactions().get(0).amount());

	}
}
