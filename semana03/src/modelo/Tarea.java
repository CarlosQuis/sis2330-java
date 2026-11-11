package modelo;

public class Tarea {

    private int id;
    private String descripcion;
    private boolean completada;
    private static int siguienteId = 1;


public Tarea(String descripcion) {
    this.id = siguienteId++;
    this.descripcion = descripcion;
    this.completada = false;
}
   public int getId() {
    return id;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    if (descripcion != null && !descripcion.isBlank()) {
        this.descripcion = descripcion;
    }
}

public boolean isCompletada() {
    return completada;
}

public void marcarCompletada() {
    this.completada = true;
  }
  @Override
public String toString() {
    return "ID: " + id
            + " | Descripcion: " + descripcion
            + " | Estado: " + (completada ? "Completada" : "Pendiente");
   }
}