package com.example.empleados.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record EmployeeRequest(

    @NotBlank(message = "El nombre es obligatorio")
    String name,

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
    String email,

    @NotNull(message = "El salario es obligatorio")
    @DecimalMin(value = "0.0", message = "El salario no puede ser negativo")
    BigDecimal salaryAmount,

    @NotBlank(message = "La moneda es obligatoria")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Use un código de moneda de tres letras")
    String salaryCurrency

) {}
