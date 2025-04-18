package com.loans.calculator.task.api.dto;

import java.math.BigDecimal;
import java.util.List;

public record LoansScheduleDto(
        BigDecimal loanAmount,
        float interestRate,
        int term,
        BigDecimal totalInterest,
        List<ScheduledPaymentDto> payments) {
}
