package servicio;
import java.util.ArrayList;

public class SistemaEstudiantes {
    private java.util.HashMap<String, modelo.Estudiante> estudiantes;
    private java.util.TreeSet<modelo.Estudiante> ranking;

    public SistemaEstudiantes() {
        estudiantes = new java.util.HashMap<>();
        ranking = new java.util.TreeSet<>();
}
    

    public boolean registrar(modelo.Estudiante estudiante) {
    if (estudiantes.containsKey(estudiante.getCodigo())) {
        return false;
    }

    estudiantes.put(estudiante.getCodigo(), estudiante);
    ranking.add(estudiante);

    return true;
}

    public modelo.Estudiante buscarPorCodigo(String codigo) {
        return estudiantes.get(codigo);
    }
    public int cantidad() {
    return estudiantes.size();
}

    public boolean actualizarPromedio(String codigo, double nuevoPromedio) {
    modelo.Estudiante estudiante = estudiantes.get(codigo);

    if (estudiante == null) {
        return false;
    }

    ranking.remove(estudiante);
    estudiante.setPromedio(nuevoPromedio);
    ranking.add(estudiante);

    return true;
}

    public boolean eliminar(String codigo) {
    modelo.Estudiante estudiante = estudiantes.remove(codigo);

    if (estudiante == null) {
        return false;
    }

    ranking.remove(estudiante);
    return true;
}

    public ArrayList<modelo.Estudiante> listarRanking() {
    return new ArrayList<>(ranking);
}

    public ArrayList<modelo.Estudiante> topN(int n) {
        ArrayList<modelo.Estudiante> ranking = listarRanking();

        if (n <= 0) {
            return new ArrayList<>();
        }

        return new ArrayList<>(ranking.subList(0, Math.min(n, ranking.size())));
    }
}