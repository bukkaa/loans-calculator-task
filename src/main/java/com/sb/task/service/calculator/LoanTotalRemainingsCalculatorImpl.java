package com.sb.task.service.calculator;

import com.sb.task.service.model.LoansSchedule;
import com.sb.task.service.model.ScheduledPayment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoanTotalRemainingsCalculatorImpl implements LoanTotalRemainingsCalculator {

    @Override
    public LoansSchedule calculateTotalRemainings(LoansSchedule loansSchedule) {

        BigDecimal payed = BigDecimal.ZERO;
        for (ScheduledPayment payment : loansSchedule.getPayments()) {
            payed = payed.add(payment.getPrincipal());
            payment.setRemaining(loansSchedule.getLoanAmount().subtract(payed));
        }
        return loansSchedule;
    }
}
