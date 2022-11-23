# Entregable

Subir códigos fuente a un repositorio y agregar en el readme las instrucciones para validar el desarrollo.

## A) Objetivo
Crear un endpoint con JAVA (spring boot java) utilizando SOAP para consumir una API tipo rest ej. (https://pokeapi.co/api/v2/pokemon/
El desarrollo consiste en consumir la API rest de https://pokeapi.co/ y en base a lo que retorna crear un endpoint en SOAP con los siguientes métodos:

* abilities
* base_experience
* held_items
* id
* name
* location_area_encounters

Todos los métodos tienen que aceptar como parámetro como String al pokemon ya que la búsqueda tiene ser en tiempo real de https://pokeapi.co/

## B) Se tiene que guardar en una base de datos h2, mysql, etc. Los request de las peticiones guardando como variables:

* ip de origin
* fecha de request
* método que se ejecuta

Se puede utilizar: mybatis, hibernate, spring jdbc, como extra se puede crear un pool deconexiones

# Ejecución
El proyecto fue desarrollado en Java utilizando [Gradle](https://gradle.org/) como herramienta de automatización de compilación e [Intellij IDEA](https://www.jetbrains.com/es-es/idea/old/) como IDE.

## Prerequisitos

Para poder ejecutar el proyecto se requiere tener instalado Java JDK y Gradle en las versiones que se indican a continuación o en versiones superiores:  

* Gradle 7.5.1
* Java 11

## Ejecutando el proyecto

### Ejecución en IDE
Para ejecutar el proyecto desde el IDE (Intellij) se requiere unicamente importarlo y ejecutar la opción "*Run*".
Una vez que el proyecto se encuentra corriendo de manera adecuada se puede acceder al WSDL desde la url http://localhost:8080/ws/pokeapi.wsdl

### Ejecución en terminal
Si el proyecto se quiere ejecutar desde la terminal se deben de seguir los siguientes comandos en el directorio raíz:

```sh
gradle bootJar
```
El comando **bootJar** construirá un Jar con todas las dependencias necesarias para poder ser ejecutado. 

```sh
java -jar build/libs/challenge-0.0.1-SNAPSHOT.jar
```
Con este comando el proyecto iniciará en el puerto 8080.

## Accediendo a la base de datos H2

El proyecto tiene configurada una base de datos en memoria H2 en la cual se guarda el registro de los request que se hacen
a los métodos expuestos. Para poder acceder es neceario abrir la url http://localhost:8080/h2-console/

La configuración de conexión es la siguiente (esto puede ser configurable desde el yml):

| Propiedad  | Valor                  |
|------------|------------------------| 
| JDBC URL   | jdbc:h2:mem:pokeapi_db | 
| User Name  | bankaya                |                 
| Password   | challenge              |              






