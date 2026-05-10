package com.bank.kata.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Value Object representing a bank transaction.
 * Immutable by design using Java record.
 */
public record Transaction(LocalDate data, BigDecimal amount, BigDecimal balance) {}
