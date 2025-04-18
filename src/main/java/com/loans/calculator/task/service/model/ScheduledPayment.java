package com.loans.calculator.task.service.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduledPayment {

    int number;
    BigDecimal payment;
    BigDecimal interest;
    BigDecimal principal;
    BigDecimal remaining;
}
