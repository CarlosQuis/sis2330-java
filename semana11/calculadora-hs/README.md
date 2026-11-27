# Calculadora en Haskell

## Descripción
Proyecto desarrollado en Haskell para practicar programación funcional, tipos de datos, funciones puras y entrada/salida (IO).

## Tecnologías utilizadas
- Haskell
- GHC 9.10.3
- Stack 3.11.1

## Funcionalidades
El proyecto implementa tres funciones:

- **suma:** suma dos números enteros.
- **doble:** calcula el doble de un número entero.
- **promedio:** calcula el promedio de dos números reales.

Además, permite ingresar dos números desde la terminal y mostrar su suma.

## Estructura del proyecto
- `src/Lib.hs`: contiene las funciones principales.
- `app/Main.hs`: contiene el programa principal.
- `test/Spec.hs`: contiene las pruebas de las funciones.

## Ejecución
Para compilar:

```bash
stack build
```

Para ejecutar:

```bash
stack run
```

Para ejecutar las pruebas:

```bash
stack test
```

Para abrir el intérprete interactivo:

```bash
stack ghci
```

## Autor
Estudiante de SIS2330.