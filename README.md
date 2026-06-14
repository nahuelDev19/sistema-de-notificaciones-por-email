# 📬 API de Envío de Notificaciones

API REST desarrollada con Spring Boot para automatizar el envío de recordatorios por correo electrónico a clientes con turnos programados.

---

## ¿Qué hace?

El sistema consulta periódicamente los turnos registrados y envía recordatorios automáticos por email cuando un turno está próximo. El objetivo es reducir ausencias y mejorar la comunicación con los clientes.

---

## 🛠 Tecnologías

| Tecnología | Uso |
|---|---|
| Java | Lenguaje principal |
| Spring Boot | Framework base |
| Spring Data JPA | Acceso a datos |
| MySQL | Base de datos |
| Resend API | Envío de emails |
| `@Scheduled` | Cron Jobs automáticos |

---

## ⚙️ Funcionamiento

- Cada **60 segundos** se ejecuta un Cron Job que identifica turnos próximos.
- Si encuentra turnos, envía automáticamente un recordatorio por email al cliente correspondiente.
- No requiere intervención manual.

---

## 🚀 Cómo correrlo localmente

### Requisitos previos

- Java 17+
- Postgrest con Neon
- Cuenta en [Resend](https://resend.com) con una API Key

### Pasos

```bash
# 1. Clonar el repositorio
git clone <url-del-repo>
cd <nombre-del-proyecto>

# 2. Configurar variables de entorno en application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
resend.api.key=tu_api_key

# 3. Correr el proyecto
./mvnw spring-boot:run
```

---

## 📄 Documentación de la API

Una vez levantado el proyecto, podés acceder a Swagger UI en:

```
http://localhost:8080/swagger-ui.html
```

---

## 👤 Contacto

**Nahuel Perea** — nahuel.perea.dev@gmail.com

---

> Versión 1.0 · Entorno local
