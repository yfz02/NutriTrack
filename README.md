# Calculadora de Calorías Basales

Aplicación web que permite calcular las calorías necesarias según el peso, sexo y nivel de actividad física del usuario. Desarrollada con Spring Boot, Maven, MySQL y tecnologías web básicas (HTML, CSS, JS).

---

## 1. Descripción

Esta aplicación permite guardar usuarios con sus datos personales (nombre, peso, sexo y nivel de actividad) y calcular automáticamente las calorías diarias recomendadas. Los datos se almacenan en una base de datos MySQL.

---

## 2. Objetivo

Facilitar el cálculo de calorías basales para distintos usuarios y permitir la gestión básica (alta y eliminación) de registros de usuarios.

---

## 3. Funcionalidades

- Formulario para ingresar nombre, peso, sexo y nivel de actividad.
- Cálculo automático de calorías según fórmulas estandarizadas.
- Almacenamiento de datos en base de datos.
- Visualización de los usuarios guardados y sus calorías.
- Eliminación individual de usuarios.

---

## 4. Implementación

### Tecnologías utilizadas:

- **Backend:**
  - Spring Boot
  - Maven
  - Lombok
  - MySQL + MySQL Workbench

- **Frontend:**
  - HTML
  - CSS
  - JavaScript

### Descripción del Backend:

- El backend está desarrollado en Spring Boot.
- Usa controladores REST para recibir los datos del usuario y calcular las calorías.
- Se emplea Lombok para reducir la escritura de código repetitivo.
- La persistencia de datos se gestiona con JPA y MySQL.

### Servicios:

- Endpoint `/api/v1/saveuser`: Guarda un usuario y devuelve las calorías calculadas.
- Endpoint `/api/v1/deleteuser/{id}`: Elimina un usuario por ID.
- Endpoint `/api/v1/all`: Devuelve todos los usuarios registrados.

---

## 5. Pruebas

Actualmente no se han realizado pruebas automatizadas por falta de tiempo. Se planea integrar pruebas unitarias y de integración en el futuro para asegurar la estabilidad del sistema.

---

## 6. Despliegue

### Requisitos:

- Java 17 o superior
- Maven
- MySQL Server + MySQL Workbench

### Pasos para ejecutar en entorno local:

1. Clonar el repositorio.
2. Crear una base de datos en MySQL llamada, por ejemplo, `calorias`.
3. Configurar las credenciales de acceso en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/calorias
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
