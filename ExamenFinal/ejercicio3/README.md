# Ejercicio #3 - Examen Final

El siguiente es el 3er ejercicio del Examen Final (26072021) de la materia de Sistemas Distribuidos (SIS258)

## Autor

Luis Fernando Salgado Miguez
correo: luisfernandosalgadomiguez@gmail.com

## Compilar y Ejecutar

### Compilar

```console
mvn compile package
```

ó

```console
mvn clean package
```

### Ejecutar

```console
java -jar target/APIREST-Alumnos-0.0.1-SNAPSHOT.jar
```

El nombre del compilado depende del artifactId y de la version en las configuraciones de [pom.xml](./pom.xml)

```xml
<artifactId>APIREST-Alumnos</artifactId>
<version>0.0.1-SNAPSHOT</version>
```

## Probar la API

Configure Swagger en [SwaggerConfig.java](./src\main\java\com\fermelli\meet\swagger\SwaggerConfig.java)

La interfaz de usuario de generada por SWAGGER corre en localhost en el puerto 8888: [SWAGGER UI](http://localhost:8888/swagger-ui.html)

Puede cambiar el puerto en: [Cambiar Puerto del servidor (actual 8888)](./src/main/resources/application.properties)
