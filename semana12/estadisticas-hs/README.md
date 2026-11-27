# Semana 12 - Haskell II

## Sistema de Estadísticas de Estudiantes

Programa desarrollado en Haskell para registrar estudiantes y procesar sus calificaciones mediante listas, tuplas, funciones y comprensión de listas.

## Módulos

- `Estadisticas.hs`: contiene las funciones para calcular el promedio, encontrar la nota más alta, ordenar estudiantes y obtener aprobados.
- `Main.hs`: permite ingresar los datos y mostrar el reporte de estudiantes.

## Funcionalidades

- Registro de estudiantes.
- Cálculo del promedio general.
- Identificación del estudiante con mayor nota.
- Ordenamiento de estudiantes por nota descendente.
- Filtrado de estudiantes aprobados (nota mayor o igual a 51).
- Control de listas vacías.

## Compilación y ejecución

Para compilar:

```bash
stack build
```

Para ejecutar:

```bash
stack run
```

## Ejemplo de ejecución

**Entrada:**

```text
3
Carlos
85
Maria
90
Pedro
45
```

**Resultados:**

- Promedio general: 73.33
- Nota más alta: Maria - 90.0
- Aprobados: Carlos y Maria

## Tecnologías

- Haskell
- GHC 9.10.3
- Stack 3.11.1