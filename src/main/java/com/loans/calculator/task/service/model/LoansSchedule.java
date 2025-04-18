package com.loans.calculator.task.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoansSchedule {

    final BigDecimal loanAmount;
    final float interestRate;
    final int term;
    BigDecimal totalInterest;

    List<ScheduledPayment> payments = new ArrayList<>();

    public void addPayment(ScheduledPayment payment) {
        payments.add(payment);
    }
}
