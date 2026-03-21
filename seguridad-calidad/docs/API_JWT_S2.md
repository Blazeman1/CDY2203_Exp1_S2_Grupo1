# API JWT - Seguridad y Calidad S2

## Login publico

- Metodo: POST
- URL: /api/auth/login
- Body:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

- Respuesta 200:

```json
{
  "token": "<jwt>"
}
```

## API privada de pacientes

### Listar pacientes

- Metodo: GET
- URL: /api/pacientes
- Header: Authorization: Bearer TOKEN_JWT

### Crear paciente

- Metodo: POST
- URL: /api/pacientes
- Header: Authorization: Bearer TOKEN_JWT
- Body:

```json
{
  "nombre": "Luna",
  "especie": "Perro",
  "raza": "Mestizo",
  "edad": 4,
  "dueno": "Ana"
}
```

## API privada de citas

### Listar citas

- Metodo: GET
- URL: /api/citas
- Header: Authorization: Bearer TOKEN_JWT

### Crear cita

- Metodo: POST
- URL: /api/citas
- Header: Authorization: Bearer TOKEN_JWT
- Body:

```json
{
  "pacienteId": 1,
  "fecha": "2026-03-22",
  "hora": "10:30",
  "motivo": "Control anual",
  "veterinario": "Dr. Soto"
}
```

## Usuarios de prueba iniciales

- admin / admin123 (ADMIN)
- vet / vet123 (VETERINARIO)
- recep / recep123 (RECEPCION)

## Conexion a base de datos

La aplicacion usa estas variables:

- DB_URL (default: jdbc:mysql://localhost:3306/seguridad_calidad_db?useSSL=false&serverTimezone=UTC)
- DB_USER (default: root)
- DB_PASS (default: password)
- JWT_SECRET
- JWT_EXPIRATION_MS

- Para configurarlas se necesita un archivo .env en el root del repo con la siguiente estructura (no subir a github):

```Dotenv
DB_URL=jdbc:mysql://localhost:3307/seguridad_calidad_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
DB_USER=root
DB_PASS=password
JWT_SECRET=mi-clave-super-secreta-de-32-caracteres-minimo
JWT_EXPIRATION_MS=3600000
```

## Ejecucion rapida

Nota de ejecucion:

- Si el puerto 3306 ya esta ocupado, usar 3307 para el contenedor y configurar DB_URL en consecuencia.
- MySQL puede tardar entre 1 y 3 minutos en quedar listo tras el primer arranque del contenedor.

1. Construir imagen MySQL:

```bash
docker build -f Dockerfile.mysql -t seguridad-calidad-mysql .
```

1. Ejecutar contenedor MySQL:

```bash
docker run --name seguridad-calidad-db -p 3306:3306 -d \
  -e MYSQL_ROOT_PASSWORD=password \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=password \
  -e MYSQL_DATABASE=seguridad_calidad_db \
  seguridad-calidad-mysql
```

Alternativa si 3306 esta en uso:

```bash
docker run --name seguridad-calidad-db -p 3307:3306 -d \
  -e MYSQL_ROOT_PASSWORD=password \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=password \
  -e MYSQL_DATABASE=seguridad_calidad_db \
  seguridad-calidad-mysql
```

1. Levantar backend:

```bash
./mvnw spring-boot:run
```
