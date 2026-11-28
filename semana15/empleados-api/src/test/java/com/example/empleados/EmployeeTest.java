package com.example.empleados;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private final Salary salary = new Salary(
        new BigDecimal("3500.00"),
        Currency.getInstance("BOB")
    );

    @Test
    void shouldCreateValidEmployee() {
        Employee employee = new Employee(
            1L, "Carlos", "carlos@example.com", salary
        );

        assertEquals(1L, employee.getId());
        assertEquals("Carlos", employee.getName());
        assertEquals("carlos@example.com", employee.getEmail());
        assertEquals(salary, employee.getSalary());
    }

    @Test
    void shouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
            new Employee(1L, " ", "carlos@example.com", salary)
        );
    }

    @Test
    void shouldRejectInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
            new Employee(1L, "Carlos", "correo-invalido", salary)
        );
    }

    @Test
    void shouldRejectNullSalary() {
        assertThrows(NullPointerException.class, () ->
            new Employee(1L, "Carlos", "carlos@example.com", null)
        );
    }

    @Test
    void shouldChangeSalary() {
        Employee employee = new Employee(
            1L, "Carlos", "carlos@example.com", salary
        );

        Salary newSalary = new Salary(
            new BigDecimal("4500.00"),
            Currency.getInstance("BOB")
        );

        employee.changeSalary(newSalary);

        assertEquals(newSalary, employee.getSalary());
    }
}
