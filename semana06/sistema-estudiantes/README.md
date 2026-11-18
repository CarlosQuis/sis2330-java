# Sistema de Estudiantes - Semana 06

## Descripción
Sistema desarrollado en Java para gestionar estudiantes mediante estructuras de datos y pruebas unitarias con Maven y JUnit 5.

## Funcionalidades
- Registrar estudiantes.
- Buscar estudiantes por código.
- Actualizar el promedio.
- Eliminar estudiantes.
- Listar estudiantes ordenados por promedio.
- Obtener los mejores estudiantes mediante `topN`.

## Estructuras de datos utilizadas

### HashMap
Se utiliza para almacenar los estudiantes asociados a su código. Permite realizar búsquedas por código de forma eficiente, con un costo promedio O(1).

### TreeSet
Se utiliza para mantener automáticamente el ranking de estudiantes ordenado por promedio descendente. Cuando dos estudiantes tienen el mismo promedio, se ordenan por código ascendente.

### ArrayList
Se utiliza para devolver los resultados del ranking y de `topN`, sin exponer directamente la estructura interna `TreeSet`.

## Validaciones
- El código del estudiante no puede ser nulo ni estar vacío.
- El promedio debe estar entre 0 y 100.
- No se permiten códigos duplicados.

## Pruebas unitarias
El proyecto utiliza JUnit 5 y contiene 13 pruebas unitarias para verificar el registro, búsqueda, actualización, eliminación, ordenamiento del ranking y funcionamiento de `topN`.

## Tecnologías
- Java 17
- Apache Maven 3.10.1
- JUnit 5.11.0
- Visual Studio Code

## Comandos Maven

Compilar:
```bash
mvn compile