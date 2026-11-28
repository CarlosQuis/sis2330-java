package com.example.empleados.infrastructure.mapper;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.infrastructure.persistence.EmployeeJpaEntity;

import java.util.Currency;

public class EmployeePersistenceMapper {

    public EmployeeJpaEntity toEntity(Employee employee) {
        return new EmployeeJpaEntity(
            employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getSalary().amount(),
            employee.getSalary().currency().getCurrencyCode()
        );
    }

    public Employee toDomain(EmployeeJpaEntity entity) {
        return new Employee(
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            new Salary(
                entity.getSalaryAmount(),
                Currency.getInstance(entity.getSalaryCurrency())
            )
        );
    }
}
