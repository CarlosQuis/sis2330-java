package com.example.empleados.domain.repository;

import com.example.empleados.domain.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
