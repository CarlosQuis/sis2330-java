package com.example.empleados.application.mapper;

import com.example.empleados.application.dto.EmployeeRequest;
import com.example.empleados.application.dto.EmployeeResponse;
import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;

import java.util.Currency;

public class EmployeeDtoMapper {

    public Employee toDomain(EmployeeRequest request) {
        return new Employee(
            null,
            request.name(),
            request.email(),
            new Salary(
                request.salaryAmount(),
                Currency.getInstance(request.salaryCurrency())
            )
        );
    }

    public EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
            employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getSalary().amount(),
            employee.getSalary().currency().getCurrencyCode()
        );
    }
}
