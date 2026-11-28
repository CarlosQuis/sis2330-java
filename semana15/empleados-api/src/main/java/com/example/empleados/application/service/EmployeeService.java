package com.example.empleados.application.service;

import com.example.empleados.application.dto.EmployeeRequest;
import com.example.empleados.application.dto.EmployeeResponse;
import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.repository.EmployeeRepository;
import com.example.empleados.application.mapper.EmployeeDtoMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.mapper = new EmployeeDtoMapper();
    }

    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = mapper.toDomain(request);
        Employee saved = employeeRepository.save(employee);
        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public EmployeeResponse findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                    "No existe un empleado con ID: " + id
                ));

        return mapper.toResponse(employee);
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public EmployeeResponse update(Long id, EmployeeRequest request) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException(
                "No existe un empleado con ID: " + id
            );
        }

        Employee employee = new Employee(
            id,
            request.name(),
            request.email(),
            new com.example.empleados.domain.model.Salary(
                request.salaryAmount(),
                java.util.Currency.getInstance(request.salaryCurrency())
            )
        );

        Employee updated = employeeRepository.save(employee);
        return mapper.toResponse(updated);
    }

    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException(
                "No existe un empleado con ID: " + id
            );
        }

        employeeRepository.deleteById(id);
    }
}
