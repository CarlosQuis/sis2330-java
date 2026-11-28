package com.example.empleados;

import com.example.empleados.application.dto.EmployeeRequest;
import com.example.empleados.application.dto.EmployeeResponse;
import com.example.empleados.application.service.EmployeeService;
import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;
    private EmployeeRequest request;

    @BeforeEach
    void setUp() {
        Salary salary = new Salary(
            new BigDecimal("3500.00"),
            Currency.getInstance("BOB")
        );

        employee = new Employee(
            1L, "Carlos", "carlos@example.com", salary
        );

        request = new EmployeeRequest(
            "Carlos",
            "carlos@example.com",
            new BigDecimal("3500.00"),
            "BOB"
        );
    }

    @Test
    void shouldCreateEmployee() {
        when(employeeRepository.save(any(Employee.class)))
            .thenReturn(employee);

        EmployeeResponse response = employeeService.create(request);

        assertEquals(1L, response.id());
        assertEquals("Carlos", response.name());
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    void shouldFindEmployeeById() {
        when(employeeRepository.findById(1L))
            .thenReturn(Optional.of(employee));

        EmployeeResponse response = employeeService.findById(1L);

        assertEquals("Carlos", response.name());
    }

    @Test
    void shouldThrowWhenEmployeeDoesNotExist() {
        when(employeeRepository.findById(99L))
            .thenReturn(Optional.empty());

        assertThrows(
            IllegalArgumentException.class,
            () -> employeeService.findById(99L)
        );
    }

    @Test
    void shouldFindAllEmployees() {
        when(employeeRepository.findAll())
            .thenReturn(List.of(employee));

        List<EmployeeResponse> responses = employeeService.findAll();

        assertEquals(1, responses.size());
        assertEquals("Carlos", responses.get(0).name());
    }

    @Test
    void shouldDeleteEmployee() {
        when(employeeRepository.existsById(1L))
            .thenReturn(true);

        employeeService.delete(1L);

        verify(employeeRepository).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonexistentEmployee() {
        when(employeeRepository.existsById(99L))
            .thenReturn(false);

        assertThrows(
            IllegalArgumentException.class,
            () -> employeeService.delete(99L)
        );

        verify(employeeRepository, never()).deleteById(99L);
    }
}
