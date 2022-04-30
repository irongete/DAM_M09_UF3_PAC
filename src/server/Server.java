package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket client;

    public Server (int puerto) {
        //inicio el servidor, intentando escuchar el puerto
        try (ServerSocket server = new ServerSocket(puerto)) {
            client = new Socket();
            client = server.accept();
        } catch (IOException e) {
          System.out.println(e);
        }
    }

    public void start() throws IOException {
        int taskCount;
        Tarea[] task;
        String clientName;
        String taskDescription;
        String taskState;

        //envío y recepción de datos
        DataInputStream input = new DataInputStream(client.getInputStream());
        DataOutputStream output = new DataOutputStream(client.getOutputStream());

        //pide al usuario su nombre
        output.writeUTF("Introduce tu nombre.");

        //recibe el nombre del usuario
        clientName = input.readUTF();

        //pide al usuario el número de tareas a realizar
        output.writeUTF("Bienvenido " + clientName + ", introduce el número de tareas a realizar.");

        //recibe el número de tareas a realizar
        taskCount = input.readInt();
        task = new Tarea[taskCount];

        //se reciben las tareas
        for (int i = 0; i <= taskCount - 1; i++) {

            //envía al cliente el número de la tarea
            output.writeInt(i);

            //pide al cliente la descripción de la tarea
            output.writeUTF("Introduce la descripción de la tarea "+ (i+1) + ".");

            //recibe la descripción de la tarea
            taskDescription = input.readUTF();

            //pide al cliente la descripción de la tarea
            output.writeUTF("Introduce el estado de la tarea "+ (i+1) + ".");

            //recibe el estado de la tarea
            taskState = input.readUTF();

            //creo una instancia para esta tarea
            task[i] = new Tarea(taskDescription, taskState);
        }

        //informo al cliente de que voy a enviar el listado de tareas
        output.writeUTF("Listado de tareas:");
        for (int i = 0; i <= taskCount - 1; i++) {
            output.writeUTF("Tarea " + (i+1) + ": " + task[i].getDescription() + ". Estado: " + task[i].getState());
        }
    }

}
