module Notas
    ( Estudiante
    , promedio
    , masAlto
    , ordenarPorNota
    , aprobados
    , parsearLinea
    ) where

import Data.List (sortBy)

type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs =
    sum (map snd xs) / fromIntegral (length xs)

masAlto :: [Estudiante] -> Maybe Estudiante
masAlto [] = Nothing
masAlto xs = Just (foldl1 mayor xs)
  where
    mayor a b
        | snd a >= snd b = a
        | otherwise = b

ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota = sortBy (\a b -> compare (snd b) (snd a))

aprobados :: [Estudiante] -> [Estudiante]
aprobados xs = [e | e <- xs, snd e >= 51]

parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',':notaTexto)
            | null nombre -> Left ("nombre vacio: " ++ linea)
            | otherwise ->
                case reads notaTexto :: [(Double, String)] of
                    [(nota, "")] -> Right (nombre, nota)
                    _ -> Left ("nota invalida: " ++ linea)
        _ -> Left ("linea sin formato nombre,nota: " ++ linea)
