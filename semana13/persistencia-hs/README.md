# Persistencia Haskell

Sistema de gestión de estudiantes desarrollado en Haskell utilizando Stack.

## Funcionalidades

- Registrar estudiantes.
- Guardar estudiantes en un archivo CSV.
- Cargar estudiantes al iniciar el programa.
- Mostrar estudiantes registrados.
- Calcular el promedio de notas.
- Detectar y reportar registros inválidos sin detener la ejecución.

## Estructura del proyecto

- `src/Modelo.hs`: tipos y funciones de cálculo.
- `src/Persistencia.hs`: lectura, escritura y análisis de archivos CSV.
- `app/Main.hs`: menú principal del sistema.
- `estudiantes.csv`: archivo de almacenamiento de estudiantes.

## Formato CSV

Cada línea contiene el nombre y la nota separados por una coma.

Ejemplo:

    carlos,85.0
    maria,90.0

## Manejo de errores

Se utiliza `Either String Estudiante` para identificar registros válidos e inválidos.

- `Right`: registro válido.
- `Left`: mensaje de error.

También se utiliza `doesFileExist` para comprobar la existencia del archivo antes de leerlo.

## Ejecución

Compilar:

    stack build

Ejecutar:

    stack run

## Tecnologías

- Haskell
- Stack
- GHC
- CSV
