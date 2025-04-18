package com.sb.task.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoansSchedule {

    BigDecimal loanAmount;
    float interestRate;
    int term;

    List<ScheduledPayment> payments;
}
