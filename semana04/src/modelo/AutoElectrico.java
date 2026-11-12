package modelo;
public class AutoElectrico extends Auto implements Electrico {

    private int capacidadBateria;

    public AutoElectrico(String marca, String modelo, double velocidadMax,
                         int numPuertas, int capacidadBateria) {
        super(marca, modelo, velocidadMax, numPuertas);
        this.capacidadBateria = capacidadBateria;
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando bateria de " +
                           capacidadBateria + " kWh");
    }

    @Override
    public String describir() {
        return "Auto electrico: " + marca + " " + modelo +
               ", bateria: " + capacidadBateria + " kWh";
    }
}
