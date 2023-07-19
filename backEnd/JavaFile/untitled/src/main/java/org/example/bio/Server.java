package org.example.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            new Server().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        while (true) {
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            outputStream.write(buffer, 0, bytesRead);
//            System.out.println(new String(buffer, 0, bytesRead));

            inputStream.close();
            outputStream.close();
            socket.close();
        }

    }
}
