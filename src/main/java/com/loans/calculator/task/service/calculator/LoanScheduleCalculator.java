package com.loans.calculator.task.service.calculator;

import com.loans.calculator.task.service.model.LoansSchedule;
import com.loans.calculator.task.service.model.ScheduledPayment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class LoanScheduleCalculator implements Calculator {

    public static final int SCALE = 8;
    public static final int SCALE_TO_SHOW = 2;

    /**
     * Calculates the schedule of payments according
     * to <a href="https://en.wikipedia.org/wiki/Amortization_calculator#The_formula">formula (wiki)</a>
     */
    @Override
    public LoansSchedule calculate(LoansSchedule loansSchedule) {
        BigDecimal i = BigDecimal.valueOf(loansSchedule.getInterestRate())
                        .divide(BigDecimal.valueOf(100)) // transform percentages into real numbers (6% -> 0,06)
                        .divide(BigDecimal.valueOf(12), SCALE, RoundingMode.HALF_UP); // evaluate monthly interest
        int n = loansSchedule.getTerm();

        BigDecimal coefficient = (i.multiply(i.add(BigDecimal.ONE).pow(n)))
                                .divide(i.add(BigDecimal.ONE).pow(n).subtract(BigDecimal.ONE), SCALE, RoundingMode.HALF_UP);

        BigDecimal loanAmount = loansSchedule.getLoanAmount();

        BigDecimal payment = loanAmount.multiply(coefficient);

        BigDecimal remaining = loanAmount;

        BigDecimal totalToPay = BigDecimal.ZERO;

        for (int paymentNumber = 1; paymentNumber <= loansSchedule.getTerm(); paymentNumber++) {

            // amount of interest within every annuity payment
            BigDecimal interest = remaining.multiply(i);

            // amount of actual loan paid within every annuity payment
            BigDecimal principal = payment.subtract(interest);

            // amount of actual loan yet to pay
            remaining = remaining.subtract(principal);

            // adjusting last payment to fully complete the loan
            // and eliminate any little remainings caused by rounding
            if (paymentNumber == loansSchedule.getTerm()) {
                payment = payment.add(remaining);
                principal = principal.add(remaining);
                remaining = BigDecimal.ZERO;
            }

            totalToPay = totalToPay.add(payment);

            loansSchedule.addPayment(new ScheduledPayment(paymentNumber,
                    payment.setScale(SCALE_TO_SHOW, RoundingMode.HALF_UP),
                    interest.setScale(SCALE_TO_SHOW, RoundingMode.HALF_UP),
                    principal.setScale(SCALE_TO_SHOW, RoundingMode.HALF_UP),
                    remaining.setScale(SCALE_TO_SHOW, RoundingMode.HALF_UP)));
        }

        loansSchedule.setTotalInterest(totalToPay.subtract(loanAmount).setScale(SCALE_TO_SHOW, RoundingMode.HALF_UP));
        return loansSchedule;
    }
}
