# DAM_M09_UF3_PAC

**Datos de conexión necesarios:**
- Dirección: localhost
- Puerto: 9876

Deberás crear un programa en Java que utilice la comunicación mediante sockets entre un cliente y un servidor, de forma que se replique este intercambio de mensajes:

| Servidor | Cliente |
| ------------ | ------------ |
| Inicia servidor |   |
|   | Cliente se conecta  |
| Pregunta nombre del cliente  |   |
|   |  Cliente envía su nombre |
|Servidor recibe nombre de cliente   |   |
|   |  Cliente envía nº de tareas a realizar |
| Bucle  | Bucle  |
| Servidor envía al cliente nº de la tarea  |   |
|   |Cliente recibe nº de tarea   |
| Servidor solicita la descripción de la tarea  |   |
|   | Cliente solicita al usuario la descripción de la tarea y se la envía al servidor  |
| Servidor solicita el estado de la tarea  |   |
|   |Cliente solicita al usuario el estado de la tarea y se la envía al servidor   |
| Fin bucle  |  Fin bucle |
| Servidor envía mensaje al cliente informando de que va enviar las tareas  |   |
| Servidor envía todas las tareas  |   |
|   | Cliente recibe la información de las tareas.  |

Además de las clases descritas, deberás crear una clase adicional Tarea para instanciar objetos para las tareas introducidas por el usuario a través del cliente. Esta clase tendrá como atributos:
- String descripcion
- String estado.
