package server;

import java.io.IOException;

public class Main {

    static int port = 9876;

    public static void main(String[] args) throws IOException {
        Server server = new Server(port);
        server.start();
    }
}