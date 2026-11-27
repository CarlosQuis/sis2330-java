module Modelo where

type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio estudiantes =
    sum (map snd estudiantes) / fromIntegral (length estudiantes)

masAlto :: [Estudiante] -> Estudiante
masAlto [x] = x
masAlto (x:y:xs)
    | snd x >= snd y = masAlto (x:xs)
    | otherwise = masAlto (y:xs)

aprobados :: [Estudiante] -> [Estudiante]
aprobados estudiantes = [e | e <- estudiantes, snd e >= 51]