module Historial
    ( registrarConsulta
    , consultarConteo
    ) where

import Control.Monad.State.Strict
import Data.Map.Strict (Map)
import qualified Data.Map.Strict as Map

registrarConsulta :: String -> State (Map String Int) ()
registrarConsulta nombre =
    modify (Map.insertWith (+) nombre 1)

consultarConteo :: String -> State (Map String Int) Int
consultarConteo nombre =
    gets (Map.findWithDefault 0 nombre)
