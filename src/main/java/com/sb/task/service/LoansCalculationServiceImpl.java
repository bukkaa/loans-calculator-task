package com.sb.task.service;

import com.sb.task.service.calculator.LoanTotalRemainingsCalculator;
import com.sb.task.service.model.LoansSchedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoansCalculationServiceImpl implements LoansCalculationService {

    // TODO создать калькулятор для расчета самих платежей
//    private final LoanScheduleCalculator scheduleCalculator;

    // TODO создать ещё один для расчета процентной-реальной частей и остатка платежей
//    private final LoanAnnualInterestCalculator annualInterestCalculator;

    // TODO создать ещё один для расчета остатка платежей
    private final LoanTotalRemainingsCalculator totalRemainingsCalculator;

    /**
     * Calculates loan schedule with annuity payments by inputting loan amount, interest rate and term
     *
     * @return {@link LoansSchedule} object containing list of calculated annuity payments
     */
    @Override
    public LoansSchedule calculateAnnualSchedule(BigDecimal amount, float interestRate, int term) {



        return null;
    }
}
