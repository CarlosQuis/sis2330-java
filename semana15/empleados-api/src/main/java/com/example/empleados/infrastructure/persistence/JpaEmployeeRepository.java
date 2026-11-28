package com.example.empleados.infrastructure.persistence;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.repository.EmployeeRepository;
import com.example.empleados.infrastructure.mapper.EmployeePersistenceMapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaEmployeeRepository implements EmployeeRepository {

    private final SpringDataEmployeeRepository springDataRepository;
    private final EmployeePersistenceMapper mapper;

    public JpaEmployeeRepository(
            SpringDataEmployeeRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
        this.mapper = new EmployeePersistenceMapper();
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeJpaEntity entity = mapper.toEntity(employee);
        EmployeeJpaEntity saved = springDataRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return springDataRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Employee> findAll() {
        return springDataRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataRepository.existsById(id);
    }
}
