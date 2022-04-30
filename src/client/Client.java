package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    //objeto de conexión
    private final Socket socket;

    //constructor
    public Client(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in); //solicitar datos por consola
        DataInputStream input = new DataInputStream(socket.getInputStream()); //recepción de datos
        DataOutputStream output = new DataOutputStream(socket.getOutputStream()); //envío de datos
        int taskCount; //número de tareas que hemos enviado al servidor
        String taskDescription; //descripción de una tarea
        String taskState; //estado de una tarea

        //el servidor pregunta el nombre
        System.out.println(input.readUTF());

        //envío del nombre al servidor
        output.writeUTF(scanner.nextLine());

        //el servidor pregunta el número de tareas
        System.out.println(input.readUTF());

        //solicito al usuario el número de tareas a realizar
        taskCount = Integer.parseInt(scanner.nextLine());

        //envío del número de tareas al servidor
        output.writeInt(taskCount);

        for (int i = 1; i<= taskCount; i++) {

            //recibe el número de la tarea
            input.readInt();

            //el servidor pregunta la descripción de la tarea
            System.out.println(input.readUTF());

            //solicito al usuario la descripción de la tarea
            taskDescription = scanner.nextLine();

            //envío la descripción de la tarea
            output.writeUTF(taskDescription);

            //el servidor pregunta el estado de la tarea
            System.out.println(input.readUTF());

            //solicito al usuario el estado de la tarea
            taskState =  scanner.nextLine();

            //envío el estado de la tarea
            output.writeUTF(taskState);
        }

        //el servidor nos va a enviar el listado de tareas
        System.out.println(input.readUTF());

        //recibo las tareas
        for (int i = 1; i <= taskCount; i++) {
            System.out.println(input.readUTF());
        }


    }
}
