package com.example.empleados;

import com.example.empleados.domain.model.Salary;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class SalaryTest {

    private final Currency bob = Currency.getInstance("BOB");

    @Test
    void shouldCreateValidSalary() {
        Salary salary = new Salary(
            new BigDecimal("3500.00"), bob
        );

        assertEquals(new BigDecimal("3500.00"), salary.amount());
        assertEquals(bob, salary.currency());
    }

    @Test
    void shouldAcceptZeroSalary() {
        Salary salary = new Salary(
            BigDecimal.ZERO, bob
        );

        assertEquals(BigDecimal.ZERO, salary.amount());
    }

    @Test
    void shouldRejectNegativeSalary() {
        assertThrows(IllegalArgumentException.class, () ->
            new Salary(new BigDecimal("-100"), bob)
        );
    }

    @Test
    void shouldRejectNullAmount() {
        assertThrows(NullPointerException.class, () ->
            new Salary(null, bob)
        );
    }

    @Test
    void shouldRejectNullCurrency() {
        assertThrows(NullPointerException.class, () ->
            new Salary(BigDecimal.ONE, null)
        );
    }
}
