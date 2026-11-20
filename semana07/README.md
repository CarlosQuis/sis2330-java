cat > README.md <<'EOF'
# Gestor de Tareas - Semana 07

## Descripcion
Aplicacion web para registrar y visualizar tareas mediante una interfaz desarrollada con Vaadin y Spring Boot.

## Tecnologias utilizadas
- Java 17
- Spring Boot 3.5.7
- Vaadin 24.8.10
- Maven

## Funcionalidades
- Registrar tareas mediante un campo de texto.
- Validar que la descripcion no este vacia.
- Mostrar las tareas registradas.
- Asignar identificadores consecutivos.
- Mostrar el estado inicial de cada tarea como pendiente.
- Limpiar el campo de texto despues de registrar una tarea.
- Mostrar una notificacion cuando se intenta agregar una tarea vacia.

## Estructura del proyecto
- GestorTareasApplication: punto de entrada de la aplicacion.
- Tarea: record que representa una tarea.
- TareasView: interfaz web para registrar y visualizar tareas.

## Ejecucion
Ejecutar desde la carpeta del proyecto:

./mvnw spring-boot:run

Abrir en el navegador:

http://localhost:8080

## Almacenamiento
Las tareas se almacenan temporalmente en memoria. Al reiniciar la aplicacion, los datos se pierden.
EOF