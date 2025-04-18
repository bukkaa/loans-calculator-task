package com.sb.task.api.dto;

import java.util.List;

public record LoansScheduleDto(List<ScheduledPaymentDto> payments) {
}
