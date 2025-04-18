package com.loans.calculator.task.service.calculator;

import com.loans.calculator.task.service.model.LoansSchedule;
import com.loans.calculator.task.service.model.ScheduledPayment;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LoanScheduleCalculatorTest {

    @Spy
    Calculator calculator = new LoanScheduleCalculator();

    @Test
    void calculate() {
        BigDecimal loanAmount = BigDecimal.valueOf(10_000);
        float interestRate = 12;
        int term = 3;

        LoansSchedule actual = calculator.calculate(new LoansSchedule(loanAmount, interestRate, term));

        AssertionsForClassTypes.assertThat(actual).isNotNull()
                .extracting(LoansSchedule::getTotalInterest).isEqualTo(BigDecimal.valueOf(10_200.66).subtract(loanAmount));

        List<ScheduledPayment> actualPayments = actual.getPayments();

        AssertionsForInterfaceTypes.assertThat(actualPayments).isNotNull().isNotEmpty()
                .extracting(ScheduledPayment::getRemaining)
                .containsExactly(BigDecimal.valueOf(6699.78), BigDecimal.valueOf(3366.56), BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
    }
}