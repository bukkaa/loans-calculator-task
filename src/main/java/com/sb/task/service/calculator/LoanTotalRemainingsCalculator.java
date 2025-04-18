package com.sb.task.service.calculator;

import com.sb.task.service.model.LoansSchedule;

public interface LoanTotalRemainingsCalculator {

    LoansSchedule calculateTotalRemainings(LoansSchedule loansSchedule);
}
