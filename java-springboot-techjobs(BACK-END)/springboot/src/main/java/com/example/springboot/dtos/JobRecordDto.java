package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record JobRecordDto(@NotBlank String title, @NotBlank String job_description,
                           @NotNull BigDecimal salary, @NotBlank String company_info,
                           @NotBlank String job_location, @NotBlank String job_style) {
}
