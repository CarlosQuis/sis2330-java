import Lib

main :: IO ()
main = do
    putStrLn "Iniciando pruebas..."

    if suma 10 20 == 30
        then putStrLn "Prueba suma: CORRECTA"
        else putStrLn "Prueba suma: ERROR"

    if doble 5 == 10
        then putStrLn "Prueba doble: CORRECTA"
        else putStrLn "Prueba doble: ERROR"

    if promedio 10 20 == 15
        then putStrLn "Prueba promedio: CORRECTA"
        else putStrLn "Prueba promedio: ERROR"