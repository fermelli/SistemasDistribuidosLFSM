# Examen Final - SISTEMAS DISTRIBUIDOS

## Enunciados

### Ejercicio 1

Realizar un programa en java utilizando sokets TCP que permita conectar a un cliente y un servidor. El cliente manda los comandos en el formato comando:valor y la respuesta tiene el formato: respuesta:valor El cliente puede mandar los siguientes comandos:

- introducir:n, permite que el servidor guarde en memoria el valor de n donde n debe ser indicado por el cliente , el valor devuelto es éxito:true si se pudo registrar o éxito:false si no se pudo registrar Ej.: introducir:5.
- cadena:string, permite que el servidor guarde en memoria el valor de cadena que es un string que debe ser indicado por el cliente, el valor devuelto es éxito:true si se pudo registrar o éxito:false Ej.: cadena:examen.
- factorial, calcula el factorial de y devuelve en una cadena la serie y devuelve resultado:string donde string es el resultado del factorial. Si n no tiene valor devoler resultado:no_n.
- fibonacci, calcula la serie fibonacci de n y devuelve en una cadena la serie y devuelve resultado:string donde el resultado es la serie fibonacci del número introducido separado por comas. Si n no tiene valor devolver resultado:no_n.
- invertir, que devuelve la cadena introducida. Si no tiene valor la cadena devolver: resultado:no_string.
- oracion, que devuelve la cadena introducida en formato oración la primera letra mayúscula. Si no tiene valor la cadena devolver: resultado:no_string

Realizar un menú en el cliente para poder manejar el sistema con las opciones

- Introducir n
- Introducir cadena
- Factorial
- Fibonaci
- Invertir
- Oración
- Salir

### Ejercicio 2

Realizar el ejercicio 1 utilizndo RMI , donde los mensajes deben ser clases tanto la solicitud como la respuesta y se debe utilizar clases para las operaciones. Luego crear una aplicación de escritorio que permita consumir los dos métodos desde una aplicación de escritorio en c# o java.

### Ejercicio 3

Utilizando Servicios REST escribir un programa en java que genere las operaciones CRUD y guarde en una base de datos mysql para el recurso alumnos que tiene los atributos: id,nombres,apellidos,sexo,fechanacimiento, dirección,celular, CU solo se podra consumir si se tienen los permisos pertinentes con la utlizacion de JWT, Enel token debe estar el nombre del usuario y el nivel que tiene (1=administrador,0=usuario) si es administrador puede hacer lasoperaciones POST, PUT,PATCH y DELETE si es usuario solo puede hacer las operaciones GET, la tabla usuarios tiene el campo usuario,password, nivel y para autenticarse existe recurso login que devuelve el token con la información del usuario generado con JWT que recibe los parámetros usuario y password, , utilizar postman para probarlos servicios para las 5 operaciones, puede utilizar php, java o c#.
