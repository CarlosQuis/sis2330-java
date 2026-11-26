
package com.tareas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final String ARCHIVO = "tareas.json";
    private final Gson gson = new Gson();
    private List<Tarea> tareas = new ArrayList<>();

    public TareaService() {
        cargar();
    }

    public synchronized List<Tarea> listar() {
        return new ArrayList<>(tareas);
    }

    public synchronized void agregar(Tarea tarea) {
        tareas.add(tarea);
        guardar();
    }

    public synchronized void actualizar(Tarea tareaActualizada) {
        tareas.replaceAll(tarea ->
                tarea.id() == tareaActualizada.id()
                        ? tareaActualizada : tarea);
        guardar();
    }

    public synchronized void eliminar(long id) {
        tareas.removeIf(tarea -> tarea.id() == id);
        guardar();
    }

    public synchronized Optional<Tarea> buscarPorId(long id) {
        return tareas.stream()
                .filter(tarea -> tarea.id() == id)
                .findFirst();
    }

    private void cargar() {
        try (FileReader reader = new FileReader(ARCHIVO)) {
            Type tipoLista = new TypeToken<List<Tarea>>() {}.getType();
            List<Tarea> datos = gson.fromJson(reader, tipoLista);

            if (datos != null) {
                tareas = datos;
            }
        } catch (IOException e) {
            tareas = new ArrayList<>();
        }
    }

    private void guardar() {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(tareas, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar las tareas", e);
        }
    }
}
