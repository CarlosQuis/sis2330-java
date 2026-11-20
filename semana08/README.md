# Semana 08 - Vaadin: Grid, Binder y CRUD

## Objetivo
Desarrollar una aplicación web utilizando Java, Spring Boot y Vaadin para gestionar tareas mediante una interfaz gráfica.

## Tecnologías utilizadas
- Java 17
- Spring Boot 3.5.7
- Vaadin 24.8.6
- Maven

## Contenidos aprendidos
- Creación de interfaces web con Vaadin.
- Uso de componentes Grid para mostrar datos.
- Uso de Binder para enlazar datos con formularios.
- Validación de campos mediante Binder.
- Selección de registros en una tabla.
- Implementación de operaciones CRUD:
  - Crear tareas.
  - Consultar tareas.
  - Actualizar tareas.
  - Eliminar tareas.

## Estructura del proyecto

\`\`\`
gestor-tareas/
├── pom.xml
├── mvnw
├── src/
│   ├── main/
│   │   ├── java/com/tareas/
│   │   │   ├── GestorTareasApplication.java
│   │   │   ├── Tarea.java
│   │   │   └── views/
│   │   │       ├── TareaEditable.java
│   │   │       └── TareasView.java
│   │   └── resources/
│   └── test/
└── .gitignore
\`\`\`

## Ejecución

Ingresar al directorio del proyecto:

\`\`\`bash
cd semana08/gestor-tareas
\`\`\`

Ejecutar la aplicación:

\`\`\`bash
./mvnw spring-boot:run
\`\`\`

Abrir en el navegador:

http://localhost:8080

## Resultado
Se desarrolló una aplicación web para registrar, visualizar, modificar y eliminar tareas, utilizando Grid, Binder, validación de formularios y componentes de Vaadin.
