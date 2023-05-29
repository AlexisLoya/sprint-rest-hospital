# Proyecto de Spring Boot 3.1.0 con Maven

Este es un proyecto de Spring Boot 3.1.0 y Maven que incluye modelos para Doctors, Patients y Users, y utiliza varias bibliotecas populares. A continuación, se proporcionan los detalles y las dependencias necesarias para configurar el proyecto.

## Requisitos

- JDK 17
- Maven

## Dependencias

El proyecto utiliza las siguientes dependencias:

- [Lombok](https://projectlombok.org/): Biblioteca para reducir la cantidad de código repetitivo, como getters y setters.
- [MySQL Connector](https://mvnrepository.com/artifact/mysql/mysql-connector-java): Conector para MySQL.
- [Flyway Core](https://mvnrepository.com/artifact/org.flywaydb/flyway-core): Biblioteca para migraciones de base de datos.
- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa): Biblioteca de Spring Boot para integración con JPA y bases de datos.
- [Spring Security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security): Biblioteca de Spring Boot para seguridad.
- [Validation API](https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api): API de validación de Java.
- [JWT](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt): Biblioteca para trabajar con JSON Web Tokens.

## Configuración

Sigue los pasos a continuación para configurar el proyecto:

1. Clona el repositorio en tu máquina local:

   ```shell
   git clone <URL_DEL_REPOSITORIO>
   ```
2. Abre el proyecto en tu IDE favorito.

3. Asegúrate de tener el JDK 17 configurado en tu IDE.

4. Actualiza la configuración de la base de datos en el archivo application.properties:
 ```shell
spring.datasource.url=jdbc:mysql://localhost:3306/tu_basededatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

   ```
## Uso

La aplicación proporciona modelos para Doctors, Patients y Users, y utiliza las bibliotecas mencionadas anteriormente para la funcionalidad relacionada. Puedes utilizar estos modelos y las dependencias correspondientes para desarrollar más funcionalidades según tus necesidades.

## Contribución
Si deseas contribuir a este proyecto, siéntete libre de hacerlo. Puedes hacer un fork del repositorio, realizar tus cambios y enviar un pull request con tus mejoras.