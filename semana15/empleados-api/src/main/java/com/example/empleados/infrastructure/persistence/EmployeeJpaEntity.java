package com.example.empleados.infrastructure.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class EmployeeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal salaryAmount;

    @Column(nullable = false, length = 3)
    private String salaryCurrency;

    protected EmployeeJpaEntity() {
    }

    public EmployeeJpaEntity(
            Long id,
            String name,
            String email,
            BigDecimal salaryAmount,
            String salaryCurrency) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salaryAmount = salaryAmount;
        this.salaryCurrency = salaryCurrency;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public String getSalaryCurrency() {
        return salaryCurrency;
    }
}
