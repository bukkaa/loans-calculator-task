package com.sb.task.api.mapper;

import com.sb.task.api.dto.LoansScheduleDto;
import com.sb.task.service.model.LoansSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ScheduledPaymentMapper.class)
public abstract class LoansScheduleMapper {

    public abstract LoansScheduleDto toDto(LoansSchedule source);
}
