
# Semana 10 – Gestor de Tareas con Vaadin y Spring Boot

## Descripción
Desarrollo de una aplicación web para gestionar tareas utilizando Vaadin, Spring Boot y persistencia de datos en formato JSON mediante Gson.

## Tecnologías utilizadas
- Java 17
- Spring Boot 3.5.7
- Vaadin 24.8.6
- Maven
- Gson 2.13.2
- Git y GitHub

## Funcionalidades
- Registrar nuevas tareas.
- Listar tareas en una tabla.
- Actualizar tareas existentes.
- Eliminar tareas.
- Consultar el detalle de una tarea mediante su ID.
- Guardar automáticamente los datos en el archivo tareas.json.
- Recuperar los datos al reiniciar la aplicación.

## Estructura del proyecto
- Tarea.java: modelo inmutable mediante record.
- TareaService.java: lógica de negocio y persistencia JSON.
- TareaEditable.java: modelo mutable para Binder.
- TareasView.java: interfaz para gestionar tareas.
- TareaDetalleView.java: vista del detalle de cada tarea.
- MainLayout.java: estructura de navegación.
- AcercaDeView.java: información del proyecto.

## Ejecución en desarrollo

```bash
./mvnw spring-boot:run
```

Abrir en el navegador: http://localhost:8080

## Generación del archivo JAR

```bash
./mvnw clean package
```

Ejecutar el archivo generado:

```bash
java -jar target/gestor-tareas-0.0.1-SNAPSHOT.jar
```

## Persistencia
Los datos se almacenan en tareas.json mediante Gson, permitiendo conservar las tareas después de cerrar y reiniciar la aplicación.

## Estado
Proyecto compilado y empaquetado correctamente. Se verificó el funcionamiento de la aplicación y la persistencia de datos.
