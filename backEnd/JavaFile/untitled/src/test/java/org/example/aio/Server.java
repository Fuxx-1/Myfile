package org.example.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) {
        try {
            new Server().run();
            TimeUnit.MINUTES.sleep(30);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void run() throws IOException {
        AsynchronousServerSocketChannel socketChannel = AsynchronousServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8082));
        socketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                socketChannel.accept(null, this);
                try {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    Future<Integer> result = client.read(buffer);
                    result.get();
                    buffer.flip();
//                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
//                    buffer.rewind();
                    Future<Integer> writeResult = client.write(buffer);
                    writeResult.get();
                    client.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                throw new RuntimeException(exc);
            }
        });
    }
}
