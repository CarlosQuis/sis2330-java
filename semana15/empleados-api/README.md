# Empleados API

API REST para gestionar empleados mediante operaciones CRUD, desarrollada con Java 17 y Spring Boot. El proyecto aplica Clean Architecture y Domain-Driven Design (DDD), separando las reglas de negocio de los detalles de persistencia y presentación.

## Arquitectura

```text
com.example.empleados
│
├── domain
│   ├── model
│   │   ├── Employee.java
│   │   └── Salary.java
│   └── repository
│       └── EmployeeRepository.java
│
├── application
│   ├── dto
│   ├── mapper
│   └── service
│       └── EmployeeService.java
│
├── infrastructure
│   ├── mapper
│   └── persistence
│
└── presentation
    └── controller
        └── EmployeeController.java
```

## Capas de la arquitectura

### 1. Domain (Dominio)

Contiene las reglas de negocio principales:

- `Employee`: entidad que representa a un empleado.
- `Salary`: objeto de valor que representa el salario y su moneda.
- `EmployeeRepository`: interfaz que define las operaciones de persistencia.

### 2. Application (Aplicación)

Contiene la lógica de coordinación de los casos de uso:

- DTO para solicitudes y respuestas.
- `EmployeeDtoMapper`: convierte DTO en objetos del dominio y viceversa.
- `EmployeeService`: implementa las operaciones CRUD.

### 3. Infrastructure (Infraestructura)

Contiene los detalles técnicos de persistencia:

- `EmployeeJpaEntity`: entidad utilizada por JPA.
- `SpringDataEmployeeRepository`: repositorio de Spring Data.
- `JpaEmployeeRepository`: implementación del contrato del dominio.
- `EmployeePersistenceMapper`: convierte entidades JPA en objetos del dominio y viceversa.

### 4. Presentation (Presentación)

Contiene el controlador REST:

- `EmployeeController`: expone los endpoints HTTP y delega las operaciones al servicio.

## Diagrama de dependencias

```text
       PRESENTATION
             |
             v
       APPLICATION
             |
             v
          DOMAIN
             ^
             |
      INFRASTRUCTURE
```

La capa Domain es independiente. Infrastructure implementa los contratos definidos por el dominio.

## Decisión de diseño: dominio sin JPA

El dominio no utiliza anotaciones ni dependencias de JPA. Esto permite mantener las reglas de negocio independientes de la tecnología de persistencia y facilita las pruebas unitarias.

La infraestructura se encarga de convertir los objetos del dominio en entidades JPA mediante mappers, evitando que las dependencias de persistencia contaminen el modelo de negocio.

## Funcionalidades

La API permite:

- Registrar empleados.
- Consultar un empleado por su ID.
- Listar todos los empleados.
- Actualizar empleados.
- Eliminar empleados.
- Validar nombres, correos electrónicos y salarios.
- Gestionar salarios con su correspondiente moneda.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5
- Mockito

## Configuración de la base de datos

El proyecto utiliza H2 en memoria.

Configuración principal:

```properties
spring.datasource.url=jdbc:h2:mem:empleadosdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=create-drop

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Consola H2:

http://localhost:8080/h2-console

## Ejecutar el proyecto

Desde la carpeta raíz del proyecto:

```bash
./mvnw spring-boot:run
```

La API estará disponible en:

```text
http://localhost:8080/api/employees
```

## Endpoints REST

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/employees` | Registrar empleado |
| GET | `/api/employees` | Listar empleados |
| GET | `/api/employees/{id}` | Consultar empleado |
| PUT | `/api/employees/{id}` | Actualizar empleado |
| DELETE | `/api/employees/{id}` | Eliminar empleado |

## Ejecutar las pruebas

Para ejecutar todas las pruebas:

```bash
./mvnw clean test
```

El proyecto incluye:

- Pruebas unitarias del dominio para `Employee` y `Salary`.
- Pruebas unitarias del servicio utilizando Mockito.
- Pruebas de integración del repositorio utilizando H2.

**Resultado de las pruebas:** 21 pruebas ejecutadas, 0 fallos y 0 errores.

## Autor

Proyecto académico desarrollado como parte de la asignatura SIS2330.
