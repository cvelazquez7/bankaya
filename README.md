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