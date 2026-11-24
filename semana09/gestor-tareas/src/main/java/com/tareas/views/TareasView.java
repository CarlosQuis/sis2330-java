
package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.ArrayList;
import java.util.List;

@Route(value = "", layout = MainLayout.class)
public class TareasView extends VerticalLayout {

    private static final List<Tarea> TAREAS = new ArrayList<>();
    private static long siguienteId = 1;

    private final Grid<Tarea> grid = new Grid<>(Tarea.class, false);
    private final TextField descripcion = new TextField("Descripción");
    private final Checkbox completada = new Checkbox("Completada");

    private final Binder<TareaEditable> binder =
            new Binder<>(TareaEditable.class);

    private Tarea seleccionActual;

    public TareasView() {

        grid.addColumn(Tarea::id).setHeader("ID");
        grid.addColumn(Tarea::descripcion).setHeader("Descripción");
        grid.addColumn(t -> t.completada() ? "Sí" : "No")
                .setHeader("Completada");

        grid.addComponentColumn(tarea ->
                new RouterLink(
                        "Ver detalle",
                        TareaDetalleView.class,
                        tarea.id()
                )
        ).setHeader("Acciones");

        grid.asSingleSelect().addValueChangeListener(event ->
                cargarEnFormulario(event.getValue()));

        binder.forField(descripcion)
                .asRequired("La descripción es obligatoria")
                .bind(TareaEditable::getDescripcion,
                        TareaEditable::setDescripcion);

        binder.forField(completada)
                .bind(TareaEditable::isCompletada,
                        TareaEditable::setCompletada);

        Button guardar = new Button("Guardar", evento -> guardar());
        Button eliminar = new Button("Eliminar", evento -> eliminar());
        Button nuevo = new Button("Nuevo", evento -> cargarEnFormulario(null));

        VerticalLayout formulario = new VerticalLayout(
                descripcion,
                completada,
                new HorizontalLayout(guardar, eliminar, nuevo)
        );

        grid.setWidth("700px");
        grid.setHeight("350px");

        formulario.setWidth("300px");

        HorizontalLayout contenido = new HorizontalLayout(grid, formulario);
        contenido.setWidthFull();

        add(contenido);

        refrescarGrid();
        cargarEnFormulario(null);
    }

    private void cargarEnFormulario(Tarea tarea) {

        seleccionActual = tarea;

        TareaEditable editable = new TareaEditable();

        if (tarea != null) {
            editable.setId(tarea.id());
            editable.setDescripcion(tarea.descripcion());
            editable.setCompletada(tarea.completada());
        }

        binder.readBean(editable);
    }

    private void guardar() {

        TareaEditable editable = new TareaEditable();

        if (!binder.writeBeanIfValid(editable)) {
            Notification.show("Revisa los datos del formulario");
            return;
        }

        if (seleccionActual == null) {

            TAREAS.add(new Tarea(
                    siguienteId++,
                    editable.getDescripcion(),
                    editable.isCompletada()
            ));

            Notification.show("Tarea agregada");

        } else {

            long id = seleccionActual.id();

            TAREAS.removeIf(t -> t.id() == id);

            TAREAS.add(new Tarea(
                    id,
                    editable.getDescripcion(),
                    editable.isCompletada()
            ));

            Notification.show("Tarea actualizada");
        }

        refrescarGrid();
        cargarEnFormulario(null);
    }

    private void eliminar() {

        if (seleccionActual == null) {
            Notification.show("Selecciona una tarea para eliminar");
            return;
        }

        TAREAS.removeIf(t -> t.id() == seleccionActual.id());

        Notification.show("Tarea eliminada");

        refrescarGrid();
        cargarEnFormulario(null);
    }

    private void refrescarGrid() {
        grid.setItems(TAREAS);
    }

    public static Tarea buscarPorId(long id) {

        return TAREAS.stream()
                .filter(t -> t.id() == id)
                .findFirst()
                .orElse(null);
    }
}
