package com.sb.task.api;

import com.sb.task.api.dto.LoansScheduleDto;
import com.sb.task.api.mapper.LoansScheduleMapper;
import com.sb.task.service.LoansCalculationService;
import com.sb.task.service.model.LoansSchedule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/loans")
@RequiredArgsConstructor
public class LoansController {

    private final LoansCalculationService loansCalculationService;
    private final LoansScheduleMapper mapper;


    @GetMapping(value = "schedule/annual", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Calculates loan schedule with annuity payments by inputting loan amount, interest rate and term")
    public LoansScheduleDto calculateLoanSchedule(
            @Parameter(required = true, description = "Amount of loan")
            @RequestParam @Valid @NotNull @Positive(message = "Amount should be a positive decimal number") BigDecimal amount,
            @Parameter(required = true, description = "Interest annual rate")
            @RequestParam @Valid @PositiveOrZero(message = "Interest rate should be a positive float or zero") float interestRate,
            @Parameter(required = true, description = "Loan term in months")
            @RequestParam @Valid @Positive(message = "Term should me a positive integer") int term) {
        LoansSchedule schedule = loansCalculationService.calculateAnnualSchedule(amount, interestRate, term);
        return mapper.toDto(schedule);
    }
}
