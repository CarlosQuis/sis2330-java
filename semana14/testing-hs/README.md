# Testing Haskell

Sistema de gestión de notas e historial de consultas desarrollado en Haskell.

## Funcionalidades

- Calcular el promedio de notas.
- Obtener el estudiante con mayor nota.
- Filtrar estudiantes aprobados.
- Ordenar estudiantes por nota.
- Registrar el historial de consultas.
- Gestionar el estado utilizando State y Map.

## Estructura

- `src/Notas.hs`: funciones de procesamiento de notas.
- `src/Historial.hs`: gestión del historial.
- `app/Main.hs`: programa principal.
- `test/Spec.hs`: pruebas unitarias y propiedades.

## Pruebas

Se utilizan:

- HUnit: 6 pruebas unitarias.
- QuickCheck: prueba de propiedad con 100 casos.

## Ejecución

Compilar:

    stack build

Ejecutar pruebas:

    stack test

Ejecutar programa:

    stack run

## Tecnologías

- Haskell
- Stack
- HUnit
- QuickCheck
- State
- Map
