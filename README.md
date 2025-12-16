hay tres capas en este ejemplo de Javalin:
El Cliente (Donde pides la comida)
Esta es la parte con la que interactúas directamente. Es tu navegador web, Postman o el cliente Java que creamos. Su trabajo es simplemente pedir algo al servidor (ej. "¡Hola, soy Martina!") y mostrarte lo que el servidor responde.
La Lógica de Negocio (La Cocina del Restaurante)
Aquí es donde pasa la magia real. Es tu código en ServidorJavalin.java. El servidor:
Recibe el pedido del cliente (la URL o el JSON).
Decide qué hacer con él (crear el saludo, en este caso).
Genera la respuesta correcta.
Javalin es el "chef" que gestiona estos pedidos y la lógica.
La Infraestructura (Las Cañerías y el Gas)
Esta capa es menos visible pero importante. Es el servidor web Jetty (que viene integrado en Javalin). Se encarga de los detalles aburridos pero necesarios:
Asegurarse de que el puerto 8000 esté abierto.
Manejar la conexión física por internet (protocolo HTTP).
Garantizar que tu pedido llegue de forma segura a la "cocina" (tu código Javalin).
