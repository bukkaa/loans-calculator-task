package com.loans.calculator.task.service;

import com.loans.calculator.task.service.calculator.LoanScheduleCalculator;
import com.loans.calculator.task.service.model.LoansSchedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoansCalculationServiceImpl implements LoansCalculationService {

    private final LoanScheduleCalculator scheduleCalculator;

    /**
     * Calculates loan schedule with annuity payments by inputting loan amount, interest rate and term
     *
     * @return {@link LoansSchedule} object containing list of calculated annuity payments
     */
    @Override
    public LoansSchedule calculateAnnualSchedule(LoansSchedule loansSchedule) {
        log.info("calculating annual schedule <== {}", loansSchedule);

        loansSchedule = scheduleCalculator.calculate(loansSchedule);

        log.info("annual schedule payments calculated ==> {}", loansSchedule);
        return loansSchedule;
    }
}
