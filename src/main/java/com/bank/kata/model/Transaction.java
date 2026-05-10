package com.bank.kata.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Value Object representing a bank transaction.
 * Immutable by design using Java record.
 */
public record Transaction(OperationType operation,
                          @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
                          BigDecimal amount,
                          BigDecimal balance) {}
