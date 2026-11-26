package com.tareas.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "acerca", layout = MainLayout.class)
public class AcercaDeView extends VerticalLayout {

    public AcercaDeView() {

        H2 titulo = new H2("Acerca del Gestor de Tareas");

        Paragraph texto = new Paragraph(
                "Aplicación desarrollada para la Semana 09 de SIS2330."
        );

        Paragraph objetivo = new Paragraph(
                "Permite gestionar tareas y navegar entre diferentes vistas."
        );

        add(titulo, texto, objetivo);
    }
}