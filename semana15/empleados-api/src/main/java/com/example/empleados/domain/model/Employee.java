package com.example.empleados.domain.model;

import java.util.Objects;

public class Employee {

    private Long id;
    private String name;
    private String email;
    private Salary salary;

    public Employee(Long id, String name, String email, Salary salary) {
        this.id = id;
        this.name = validateName(name);
        this.email = validateEmail(email);
        this.salary = Objects.requireNonNull(
            salary, "El salario no puede ser nulo"
        );
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío"
            );
        }
        return name;
    }

    private String validateEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException(
                "El correo electrónico no es válido"
            );
        }
        return email;
    }

    public void changeSalary(Salary newSalary) {
        this.salary = Objects.requireNonNull(
            newSalary, "El salario no puede ser nulo"
        );
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

    public Salary getSalary() {
        return salary;
    }
}
