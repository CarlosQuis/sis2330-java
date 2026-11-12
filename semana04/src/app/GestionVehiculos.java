package app;

import modelo.*;
import java.util.ArrayList;

public class GestionVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Auto("Toyota", "Corolla", 180, 4));
        vehiculos.add(new Moto("Honda", "CBR", 220, 600));
        vehiculos.add(new Camion("Volvo", "FH", 120, 20));
        vehiculos.add(new AutoElectrico("Tesla", "Model 3", 250, 4, 75));

        for (Vehiculo v : vehiculos) {

            System.out.println(v.describir());

            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;
                e.cargarBateria();
            }

            System.out.println("----------------------");
        }
    }
}
