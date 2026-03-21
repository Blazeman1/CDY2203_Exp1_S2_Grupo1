# Informe de Actividad - Semana 1

## Datos Generales

- Asignatura: Seguridad y Calidad en el Desarrollo
- Docente: Jonathan Fletcher Castro
- Fecha de entrega: 16/03/2026
- Grupo 1:
  - Fernando Fuentes Allende
  - Francisco Parra Andia
  - Karla Santibáñez Gutiérrez

## 1. Descripcion de la aplicacion y su proposito

### 1.1 Contexto del problema

[Describir brevemente la necesidad de la veterinaria y el problema que resuelve la aplicacion.]

### 1.2 Objetivo de la solucion

[Explicar el objetivo principal del sistema en esta semana.]

### 1.3 Alcance implementado

- Autenticacion y autorizacion con Spring Security.
- Registro de pacientes en memoria.
- Programacion de citas en memoria.
- Vistas con Thymeleaf y estilo CSS basico.

### 1.4 Alcance no implementado (fases posteriores)

[Indicar funcionalidades futuras como ficha medica completa, facturacion detallada, persistencia en base de datos, integración de frameworks JS/CSS, etc.]

## 2. Estructura general de la aplicacion

### 2.1 Arquitectura general (frontend, backend y datos)

[Describir como se organiza la aplicacion en capas.]

- Frontend:
  - Plantillas Thymeleaf utilizadas:
    - home.html
    - login.html
    - citas.html
    - pacientes.html
  - Archivos CSS principales:
    - style.css
- Backend:
  - Controladores principales:
    - package: controller
      - HomeController.java
      - PacientesController.java
      - CitasController.java
  - Configuracion de seguridad:
    - WebSecurityConfig.java
- Datos:
  - [Explicar almacenamiento en memoria para usuarios, pacientes y citas]
    - Para persistir los datos de los pacientes y citas en la aplicación se utilizan:
      - CitaMemoryStore.java
      - PacienteMemoryStore.java

### 2.2 Uso de Spring Security y proteccion de URLs

[Explicar como se configuro el `SecurityFilterChain` y la pagina de login personalizada.]

#### 2.2.1 Rutas publicas

- `GET /`
- `GET /login`
- Recursos estaticos (`/css/**`, `/js/**`, `/images/**`)

#### 2.2.2 Rutas privadas

Las rutas privadas de la aplicación son:

- `/pacientes`
- `/citas`

#### 2.2.3 Usuarios y roles en memoria

| Usuario | Rol | Acceso esperado |
| --- | --- | --- |
| [usuario1] | [ADMIN] | [Completar] |
| [usuario2] | [VETERINARIO] | [Completar] |
| [usuario3] | [RECEPCION] | [Completar] |

### 2.3 Framework y tecnologias utilizadas

- Spring Boot: [uso principal en el proyecto]
- Spring Security: [autenticacion/autorizacion]
- Thymeleaf: [render de vistas]
- CSS: [estilo visual basico]
- Maven: [build y dependencias]
- VS Code: [entorno de desarrollo]

## 3. Rutas y funcionalidades

### 3.1 Rutas publicas

#### 3.1.1 Pagina de inicio

- URL: [Completar]
- Acceso: Publico
- Descripcion funcional: [Completar]

Evidencia (captura):
![Captura pagina de inicio](../evidencias/captura-inicio.png)
<!-- Es un borrador para rellenar con capturas -->
#### 3.1.2 Pagina de login

- URL: [Completar]
- Acceso: Publico
- Descripcion funcional: [Completar]

Evidencia (captura):
![Captura login](../evidencias/captura-login.png)

### 3.2 Rutas privadas

#### 3.2.1 Modulo de pacientes

- URL: [Completar]
- Acceso por rol: [Completar]
- Acciones disponibles:
  - [Registrar paciente]
  - [Listar pacientes]
  - [Otros]

Evidencia (captura formulario):
![Captura pacientes formulario](../evidencias/captura-pacientes-form.png)

Evidencia (captura listado):
![Captura pacientes listado](../evidencias/captura-pacientes-lista.png)

#### 3.2.2 Modulo de citas

- URL: [Completar]
- Acceso por rol: [Completar]
- Acciones disponibles:
  - [Programar cita]
  - [Listar citas]
  - [Otros]

Evidencia (captura formulario):
![Captura citas formulario](../evidencias/captura-citas-form.png)

Evidencia (captura listado):
![Captura citas listado](../evidencias/captura-citas-lista.png)

## 4. Evidencias tecnicas (codigo y configuracion)

### 4.1 Estructura de carpetas del proyecto

[Incluir arbol resumido de `src/main/java` y `src/main/resources`.]

```text
[Pegue aqui la estructura de carpetas relevante]
```

### 4.2 Fragmento de configuracion de seguridad

[Incluir fragmento de `WebSecurityConfig` donde se vean rutas publicas/privadas y login.]

```java
// Pegue aqui su SecurityFilterChain
```

### 4.3 Fragmento de usuarios en memoria

[Incluir fragmento de `UserDetailsService` en memoria con 3 usuarios.]

```java
// Pegue aqui su configuracion de usuarios en memoria
```

### 4.4 Fragmento de controlador y vista

[Incluir un ejemplo de controlador y una plantilla Thymeleaf usada.]

```java
// Controlador de ejemplo
```

```html
<!-- Vista Thymeleaf de ejemplo -->
```

## 5. Pruebas funcionales basicas

### 5.1 Casos de prueba ejecutados

| ID | Caso | Resultado esperado | Resultado obtenido |
| --- | --- | --- | --- |
| CP-01 | Acceso a `/login` sin autenticar | Permitir acceso | [Completar] |
| CP-02 | Acceso a ruta privada sin autenticar | Redirigir a login | [Completar] |
| CP-03 | Login con credenciales validas | Ingreso correcto | [Completar] |
| CP-04 | Login con credenciales invalidas | Mensaje de error | [Completar] |
| CP-05 | Registro de paciente | Paciente guardado en memoria | [Completar] |
| CP-06 | Programacion de cita | Cita guardada en memoria | [Completar] |

### 5.2 Evidencias de pruebas

![Captura prueba acceso privado](../evidencias/captura-prueba-ruta-privada.png)
![Captura prueba login correcto](../evidencias/captura-prueba-login-ok.png)
![Captura prueba login error](../evidencias/captura-prueba-login-error.png)

## 6. Conclusiones

### 6.1 Aprendizajes del equipo


Karla:
Durante esta semana logré aprender sobre la implementación de plantillas con thymeleaf, y el manejo y presentación
de datos por medio de las mismas. También tuve la oportunidad de implementar estructura en capas para el desarrollo de una app modular, con responsabilidades bien definidas. 

### 6.2 Dificultades y soluciones

Se presentaron algunas complicaciones iniciales para ambientar la aplicación, pero se solucionó implementando:

  - Modificaciones en el POM para que la aplicación compilara con el nombre de paquetes propuesto en la actividad
  - Implementar una estructura de capas para separar responsabilidades entre los distintos módulos de la aplicación
  - Implementar modelos de datos para los objetos Cita y Paciente
  - Implementar repositorios para la persistencia de datos en memoria
  - Agregar las templates necesarias para permitir la interacción del usuario con la aplicación web
  - Agregar mappings y logins a home controller
  - Documentación en cada clase de la aplicación.

### 6.3 Mejoras futuras

[Describir mejoras para siguientes semanas.]

## 7. Referencias

- Guia de aprendizaje: [URL]
- Pauta de evaluacion: [URL]
- Instrucciones especificas: [URL]
- Actividad de la semana: [URL]
- Documentacion Spring Security: <https://spring.io/projects/spring-security>
- Documentacion Thymeleaf: <https://www.thymeleaf.org/documentation.html>

---

## Checklist de entrega (maximo 5 paginas)

- [ ] Seccion 1 completa: descripcion y proposito.
- [ ] Seccion 2 completa: arquitectura + seguridad + tecnologias.
- [ ] Seccion 3 completa: rutas publicas y privadas con acceso por rol.
- [ ] Evidencias y capturas insertadas.
- [ ] Casos de prueba completados.
- [ ] Redaccion final revisada (ortografia y claridad).
- [ ] Extension ajustada al maximo solicitado.
