# Tarea 6 Api REST (tarea8 en el repositorio)

El siguiente ejemplo es una tarea de la materia de Sistemas Distribuidos (SIS258) como modificacion del ejemplo [GIT LAB - REST client](https://gitlab.com/cmontellano/rest-client)

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
java -jar target/rest-store-0.0.1-SNAPSHOT.jar
```

## Probar la API

La interfaz de usuario de generada por SWAGGER corre en localhost en el puerto 8888: [SWAGGER UI](http://localhost:8888/swagger-ui.html)

Puede cambiar el puerto en: [Cambiar Puerto del servidor (actual 8888)](./src/main/resources/application.properties)
