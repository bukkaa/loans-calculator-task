package com.loans.calculator.task.api.mapper;

import com.loans.calculator.task.api.dto.LoansScheduleDto;
import com.loans.calculator.task.service.model.LoansSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ScheduledPaymentMapper.class)
public abstract class LoansScheduleMapper {

    public abstract LoansScheduleDto toDto(LoansSchedule source);
}
