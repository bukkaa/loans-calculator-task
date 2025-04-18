package com.loans.calculator.task.service;

import com.loans.calculator.task.service.model.LoansSchedule;

public interface LoansCalculationService {

    LoansSchedule calculateAnnualSchedule(LoansSchedule loansSchedule);
}
