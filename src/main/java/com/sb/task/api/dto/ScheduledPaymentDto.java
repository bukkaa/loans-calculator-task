package com.sb.task.api.dto;

import java.math.BigDecimal;

public record ScheduledPaymentDto(
    int number,
    BigDecimal payment,
    BigDecimal interest,
    BigDecimal principal,
    BigDecimal remaining
) { }
