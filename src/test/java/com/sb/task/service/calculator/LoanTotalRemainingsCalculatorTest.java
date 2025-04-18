package com.sb.task.service.calculator;

import com.sb.task.service.model.LoansSchedule;
import com.sb.task.service.model.ScheduledPayment;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LoanTotalRemainingsCalculatorTest {

    @Spy
    LoanTotalRemainingsCalculator calculator = new LoanTotalRemainingsCalculatorImpl();

    // TODO проверить чтобы вычисление не было меньше 0

    @Test
    void calculateTotalRemainings() {
        List<ScheduledPayment> scheduledPayments = List.of(
                new ScheduledPayment(1, null, null, BigDecimal.valueOf(1893), null),
                new ScheduledPayment(2, null, null, BigDecimal.valueOf(1932), null),
                new ScheduledPayment(3, null, null, BigDecimal.valueOf(1972), null));

        LoansSchedule loansSchedule = new LoansSchedule();
        loansSchedule.setPayments(scheduledPayments);
        loansSchedule.setLoanAmount(BigDecimal.valueOf(100_000));

        LoansSchedule actual = calculator.calculateTotalRemainings(loansSchedule);

        AssertionsForClassTypes.assertThat(actual).isNotNull();

        List<ScheduledPayment> actualPayments = actual.getPayments();
        AssertionsForInterfaceTypes.assertThat(actualPayments).isNotNull().isNotEmpty()
                .extracting(ScheduledPayment::getRemaining)
                .containsExactly(BigDecimal.valueOf(98_107), BigDecimal.valueOf(96_175), BigDecimal.valueOf(94_203));
    }
}