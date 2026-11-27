module Main where

import Estadisticas
import Control.Monad (replicateM)

main :: IO ()
main = do
    putStrLn "=== SISTEMA DE ESTADISTICAS DE ESTUDIANTES ==="
    putStrLn "Ingrese la cantidad de estudiantes:"
    n <- readLn

    estudiantes <- replicateM n leerEstudiante

    putStrLn "\n=== REPORTE DE ESTUDIANTES ==="

    if null estudiantes
        then putStrLn "No hay estudiantes registrados."
        else do
            putStrLn ("Promedio general: " ++ show (promedio estudiantes))

            let mejor = masAlto estudiantes
            putStrLn ("Nota mas alta: " ++ fst mejor ++ " - " ++ show (snd mejor))

            putStrLn "\nEstudiantes ordenados por nota:"
            mapM_ print (ordenarPorNota estudiantes)

            putStrLn "\nEstudiantes aprobados:"
            mapM_ print (aprobados estudiantes)

leerEstudiante :: IO Estudiante
leerEstudiante = do
    putStrLn "\nIngrese el nombre del estudiante:"
    nombre <- getLine
    putStrLn "Ingrese su nota:"
    nota <- readLn
    return (nombre, nota)