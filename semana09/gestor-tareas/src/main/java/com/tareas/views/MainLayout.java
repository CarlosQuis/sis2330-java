
package com.tareas.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {

        DrawerToggle toggle = new DrawerToggle();

        H2 titulo = new H2("Gestor de Tareas");

        RouterLink tareasLink =
                new RouterLink("Lista de Tareas", TareasView.class);

        RouterLink acercaLink =
                new RouterLink("Acerca de", AcercaDeView.class);

        VerticalLayout menu = new VerticalLayout(
                tareasLink,
                acercaLink
        );

        addToNavbar(toggle, titulo);
        addToDrawer(menu);
    }
}
