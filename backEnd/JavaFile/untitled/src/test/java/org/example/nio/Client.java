package org.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8081));
        ByteBuffer buffer = ByteBuffer.wrap("This is a Big Text!!!This is a Big Text!!!This is a Big Text!!!".getBytes());
        socketChannel.write(buffer);
        buffer.clear();
        int bytesRead = socketChannel.read(buffer);
//        System.out.println(new String(buffer.array(), 0, bytesRead));
        socketChannel.close();
    }
}
