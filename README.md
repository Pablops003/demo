
# Demo

Este es un proyecto de demostración creado por [Pablops003](https://github.com/Pablops003). 
El propósito de este repositorio es servir como plantilla o base para futuros desarrollos 
o como referencia técnica.

![Logo de la Aplicación](docs/LogoTFG.png)


## 🚀 Instalación

Clona el repositorio:

```bash
git clone https://github.com/Pablops003/demo.git
docker build -t Pablops003/demo .
```

## 📂 Estructura del proyecto
```
demo/
├── src/
│   ├── main/
│   │   └── java/com/example/tfg/api/   # Controladores, entidades, repositorios
│   └── resources/                      # application.properties
├── Dockerfile                          # Imagen del backend
├── docker-compose.yml                  # Base de datos y pgAdmin
├── build.gradle                        # Configuración de Gradle
└── README.md                           # Este archivo

```

## 🛠 Tecnologías
Este proyecto usa:

* Lenguaje: Java 17
* Frameworks: Spring Boot, Spring Security, Spring Data JPA
* Base de Datos: PostgreSQL (via Docker)
* Herramientas: Docker, Gradle, pgAdmin, Postman


## Funcionalidades clave
* Registro seguro de usuarios.
* Autenticación mediante Spring Security.
* Relación 1:N entre usuarios y tareas.
* CRUD completo de tareas.
* Filtros por tareas completadas y pendientes.
* Protección contra acceso indebido a datos de otros usuarios.

API testable con Postman.
## 🤝 Contribuciones
¡Las contribuciones son bienvenidas!

1. Haz un fork del proyecto.

2. Crea tu rama de funcionalidad (git checkout -b feature/mi-funcionalidad).

3. Haz commit de tus cambios (git commit -m 'Añadir nueva funcionalidad').

4. Haz push a la rama (git push origin feature/mi-funcionalidad).

5. Abre un Pull Request.

##  Presentación del TFG

Puedes ver la presentación oficial aquí:

📄 [Ver presentación en PDF](docs/presentación1.pdf)