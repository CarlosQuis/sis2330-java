module Persistencia where

import Modelo
import System.Directory (doesFileExist)
import Text.Read (readMaybe)

parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',':notaTexto)
            | null nombre ->
                Left "El nombre del estudiante está vacío"
            | otherwise ->
                case readMaybe notaTexto :: Maybe Double of
                    Nothing -> Left "La nota no es un número válido"
                    Just nota
                        | nota < 0 || nota > 100 ->
                            Left "La nota debe estar entre 0 y 100"
                        | otherwise ->
                            Right (nombre, nota)
        _ -> Left "Formato incorrecto. Se esperaba nombre,nota"

formatearLinea :: Estudiante -> String
formatearLinea (nombre, nota) =
    nombre ++ "," ++ show nota

guardarEstudiantes :: FilePath -> [Estudiante] -> IO ()
guardarEstudiantes ruta estudiantes =
    writeFile ruta (unlines (map formatearLinea estudiantes))

cargarEstudiantes :: FilePath -> IO [Either String Estudiante]
cargarEstudiantes ruta = do
    existe <- doesFileExist ruta

    if not existe
        then return []
        else do
            contenido <- readFile ruta
            let lineas = filter (not . null) (lines contenido)
            return (map parsearLinea lineas)
