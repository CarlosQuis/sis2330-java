import modelo.Estudiante;
import servicio.SistemaEstudiantes;

public class Principal {
    public static void main(String[] args) {
        SistemaEstudiantes sistema = new SistemaEstudiantes();

        sistema.registrar(new Estudiante("E1", "Ana", 85.0));
        sistema.registrar(new Estudiante("E2", "Luis", 95.0));
        sistema.registrar(new Estudiante("E3", "Carlos", 78.0));

        System.out.println("RANKING DE ESTUDIANTES:");

        for (Estudiante estudiante : sistema.listarRanking()) {
            System.out.println(
                estudiante.getCodigo() + " - " +
                estudiante.getNombre() + " - " +
                estudiante.getPromedio()
            );
        }
    }
}