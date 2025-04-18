package com.sb.task.service;

import com.sb.task.service.model.LoansSchedule;

import java.math.BigDecimal;

public interface LoansCalculationService {

    LoansSchedule calculateAnnualSchedule(BigDecimal amount, float interestRate, int term);
}
