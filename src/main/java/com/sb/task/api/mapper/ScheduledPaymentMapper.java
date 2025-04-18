package com.sb.task.api.mapper;

import com.sb.task.api.dto.ScheduledPaymentDto;
import com.sb.task.service.model.ScheduledPayment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduledPaymentMapper {

    List<ScheduledPaymentDto> toDtos(List<ScheduledPayment> source);

    ScheduledPaymentDto toDto(ScheduledPayment source);
}
