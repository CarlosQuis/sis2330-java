package com.example.empleados.application.dto;

import java.math.BigDecimal;

public record EmployeeResponse(
    Long id,
    String name,
    String email,
    BigDecimal salaryAmount,
    String salaryCurrency
) {}
