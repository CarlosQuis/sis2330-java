module Main where

import Modelo
import Persistencia
import Control.Monad (forM_)
import Data.Either (rights)

main :: IO ()
main = do
    putStrLn "=== SISTEMA DE PERSISTENCIA DE ESTUDIANTES ==="

    resultados <- cargarEstudiantes "estudiantes.csv"

    let estudiantes = rights resultados
    let errores = [mensaje | Left mensaje <- resultados]

    putStrLn "\nEstudiantes cargados:"
    forM_ estudiantes $ \(nombre, nota) ->
        putStrLn (nombre ++ " - " ++ show nota)

    forM_ errores $ \mensaje ->
        putStrLn ("Error al cargar: " ++ mensaje)

    menu estudiantes

menu :: [Estudiante] -> IO ()
menu estudiantes = do
    putStrLn "\n1. Registrar estudiante"
    putStrLn "2. Mostrar estudiantes"
    putStrLn "3. Mostrar promedio"
    putStrLn "4. Salir"
    putStr "Seleccione una opcion: "

    opcion <- getLine

    case opcion of
        "1" -> do
            putStr "Nombre: "
            nombre <- getLine

            putStr "Nota: "
            notaTexto <- getLine

            case parsearLinea (nombre ++ "," ++ notaTexto) of
                Left mensaje -> do
                    putStrLn mensaje
                    menu estudiantes

                Right estudiante -> do
                    let nuevos = estudiantes ++ [estudiante]
                    guardarEstudiantes "estudiantes.csv" nuevos
                    putStrLn "Estudiante guardado correctamente."
                    menu nuevos

        "2" -> do
            putStrLn "\nLista de estudiantes:"
            forM_ estudiantes $ \(nombre, nota) ->
                putStrLn (nombre ++ " - " ++ show nota)
            menu estudiantes

        "3" -> do
            putStrLn ("Promedio: " ++ show (promedio estudiantes))
            menu estudiantes

        "4" -> putStrLn "Hasta luego."

        _ -> do
            putStrLn "Opcion no valida."
            menu estudiantes
