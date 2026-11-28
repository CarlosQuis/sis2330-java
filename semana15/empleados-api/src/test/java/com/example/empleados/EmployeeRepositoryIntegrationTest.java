package com.example.empleados;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import com.example.empleados.infrastructure.persistence.EmployeeJpaEntity;
import com.example.empleados.infrastructure.persistence.SpringDataEmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({
    com.example.empleados.infrastructure.persistence.JpaEmployeeRepository.class,
    com.example.empleados.infrastructure.mapper.EmployeePersistenceMapper.class
})
class EmployeeRepositoryIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SpringDataEmployeeRepository springDataRepository;

    @BeforeEach
    void cleanDatabase() {
        springDataRepository.deleteAll();
    }

    private Employee createEmployee() {
        return new Employee(
            null,
            "Carlos",
            "carlos@example.com",
            new Salary(
                new BigDecimal("3500.00"),
                Currency.getInstance("BOB")
            )
        );
    }

    @Test
    void shouldSaveEmployee() {
        Employee saved = employeeRepository.save(createEmployee());

        assertNotNull(saved.getId());
        assertEquals("Carlos", saved.getName());
    }

    @Test
    void shouldFindEmployeeById() {
        Employee saved = employeeRepository.save(createEmployee());

        var found = employeeRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Carlos", found.get().getName());
    }

    @Test
    void shouldFindAllEmployees() {
        employeeRepository.save(createEmployee());

        assertEquals(1, employeeRepository.findAll().size());
    }

    @Test
    void shouldDeleteEmployee() {
        Employee saved = employeeRepository.save(createEmployee());

        employeeRepository.deleteById(saved.getId());

        assertFalse(employeeRepository.existsById(saved.getId()));
    }

    @Test
    void shouldPersistSalaryAndCurrency() {
        Employee saved = employeeRepository.save(createEmployee());

        Employee found = employeeRepository.findById(saved.getId())
            .orElseThrow();

        assertEquals(new BigDecimal("3500.00"), found.getSalary().amount());
        assertEquals(
            Currency.getInstance("BOB"),
            found.getSalary().currency()
        );
    }
}
