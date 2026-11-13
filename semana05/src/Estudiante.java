public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private double promedio;

    public Estudiante(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public int compareTo(Estudiante otro) {
        // Orden descendente por promedio (mejor primero)
        return Double.compare(otro.promedio, this.promedio);
    }
}