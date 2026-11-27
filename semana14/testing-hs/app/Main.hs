module Main where

import Notas
import Historial
import Control.Monad.State.Strict (execState)
import qualified Data.Map.Strict as Map

main :: IO ()
main = do
    putStrLn "=== SISTEMA DE NOTAS E HISTORIAL ==="

    let lineas =
            [ "Carlos,85"
            , "Maria,90"
            , "Pedro,45"
            , "Ana,75"
            ]

    let resultados = map parsearLinea lineas
    let estudiantes = [e | Right e <- resultados]

    putStrLn "\nReporte de estudiantes:"
    mapM_ print estudiantes

    putStrLn ("\nPromedio: " ++ show (promedio estudiantes))

    putStrLn "\nEstudiante con mayor nota:"
    print (masAlto estudiantes)

    putStrLn "\nEstudiantes aprobados:"
    mapM_ print (aprobados estudiantes)

    let historial = execState
            (mapM_ (registrarConsulta . fst) estudiantes)
            Map.empty

    putStrLn "\nHistorial de consultas:"
    mapM_ print (Map.toList historial)
