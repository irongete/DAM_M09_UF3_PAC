package client;

import java.io.IOException;

public class Main {

    static String ip = "localhost";
    static int port = 9876;

    public static void main(String[] args) throws IOException {
        Client client = new Client(ip, port);
        client.start();
    }
}
