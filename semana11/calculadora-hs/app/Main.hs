
module Main (main) where

import Lib

main :: IO ()
main = do
    putStrLn "Ingrese el primer numero:"
    entrada1 <- getLine

    putStrLn "Ingrese el segundo numero:"
    entrada2 <- getLine

    let numero1 = read entrada1 :: Int
    let numero2 = read entrada2 :: Int

    let resultado = suma numero1 numero2

    putStrLn ("La suma es: " ++ show resultado)
