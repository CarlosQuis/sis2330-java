package com.example.empleados.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public record Salary(BigDecimal amount, Currency currency) {

    public Salary {
        Objects.requireNonNull(amount, "El salario no puede ser nulo");
        Objects.requireNonNull(currency, "La moneda no puede ser nula");

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                "El salario no puede ser negativo"
            );
        }
    }
}
