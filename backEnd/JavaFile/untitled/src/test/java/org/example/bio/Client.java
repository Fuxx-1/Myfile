package org.example.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                try {
                    new Client().run();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private void run() throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("This is a Big Text!!!This is a Big Text!!!This is a Big Text!!!".getBytes());
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
//        System.out.println(new String(buffer, 0, bytesRead));
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
