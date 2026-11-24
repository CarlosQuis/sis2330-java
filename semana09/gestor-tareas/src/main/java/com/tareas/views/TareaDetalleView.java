
package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "tareas", layout = MainLayout.class)
public class TareaDetalleView extends VerticalLayout
        implements HasUrlParameter<Long> {

    private final H2 titulo = new H2();
    private final Paragraph contenido = new Paragraph();

    public TareaDetalleView() {
        add(titulo, contenido);
    }

    @Override
    public void setParameter(BeforeEvent evento, Long id) {

        Tarea tarea = TareasView.buscarPorId(id);

        if (tarea == null) {
            titulo.setText("Tarea no encontrada");
            contenido.setText("No existe una tarea con el ID: " + id);
        } else {
            titulo.setText("Detalle de la tarea");
            contenido.setText(
                    "ID: " + tarea.id()
                    + " | Descripción: " + tarea.descripcion()
                    + " | Completada: " + tarea.completada()
            );
        }
    }
}
