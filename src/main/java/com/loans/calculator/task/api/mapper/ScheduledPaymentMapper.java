package com.loans.calculator.task.api.mapper;

import com.loans.calculator.task.api.dto.ScheduledPaymentDto;
import com.loans.calculator.task.service.model.ScheduledPayment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduledPaymentMapper {

    List<ScheduledPaymentDto> toDtos(List<ScheduledPayment> source);

    ScheduledPaymentDto toDto(ScheduledPayment source);
}
