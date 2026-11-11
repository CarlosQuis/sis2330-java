package app;

import modelo.Tarea;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorTareas {
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static void agregar(String descripcion) {
    tareas.add(new Tarea(descripcion));
    System.out.println("Tarea agregada.");
}
private static void listar() {
    if (tareas.isEmpty()) {
        System.out.println("No hay tareas.");
        return;
    }

    for (Tarea t : tareas) {
        System.out.println(t);
    }
}
private static void completar(int id) {
    for (Tarea t : tareas) {
        if (t.getId() == id) {
            t.marcarCompletada();
            System.out.println("Tarea " + id + " marcada como completada.");
            return;
        }
    }

    System.out.println("No existe una tarea con ID " + id);
}
private static void eliminar(int id) {
    boolean eliminado = tareas.removeIf(t -> t.getId() == id);

    System.out.println(eliminado
            ? "Tarea eliminada."
            : "No existe una tarea con ID " + id);
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int op = 0;

    while (op != 5) {
        System.out.println("\n--- GESTOR DE TAREAS ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");

        try {
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Ingrese la descripcion: ");
                    String descripcion = sc.nextLine();
                    agregar(descripcion);
                }
                case 2 -> listar();
                case 3 -> {
                    System.out.print("Ingrese el ID: ");
                    int id = sc.nextInt();
                    completar(id);
                }
                case 4 -> {
                    System.out.print("Ingrese el ID: ");
                    int id = sc.nextInt();
                    eliminar(id);
                }
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un numero.");
            sc.nextLine();
        }
    }

    sc.close();
}
}