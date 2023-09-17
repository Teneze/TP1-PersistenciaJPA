<div> 
    <p>
        <img
            src="logo.png"
            alt="logochilepicante"
            width="100px"
            height="100px"
        /> 
     </p>
</div>

# TP1 - Persistencia JPA 
Este es el repositorio de la entrega del Trabajo Practico Numero 1 sobre "Persistencia Java Persistence API" (JPA)"

## Conclusiones/Problemas durante el enfrentamiento con el TP
Este practico me resultó muy desafiante ya que en lo personal no considero Java como mi "zona de comfort". 

Mi mayor problema fue el error "Caused by: java.lang.NullPointerException: Cannot invoke "java.util.List.add(Object)" because "this.productos" is null", estaba teniendo conflictos en la Inicialización ya que por lo que entendí estaba intentando agregar un objeto a una lista (productos) que resultaba null, por lo que no se estaba inicializado correctamente. 

Por lo cual, fui revisando las entidades especificas en el rango del problema ("Cliente", "Rubro" y "Pedido") y luego de observar mientras revisaba que cada relación sea congruente pude darme cuenta que luego de inicializar las listas me estaba faltando el @Builder.Default.

Luego de agregar esta notación pude realizar con alivio la ejecución del proyecto.

## Ejecución del Proyecto

1- En la pantalla principal del repositorio seleccionar "<> Code"

2- Seleccionar la ultima opción "Download ZIP"

3- Se descargara un archivo comprimido del repositorio

4- Descomprima el archivo

5- Abra el proyecto en Intellij IDEA

6- Ejecute la clase Tp1JpaApplication

## Realizado por
[Ezquiel Tenerini](https://github.com/Teneze)
