package org.example.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class Client {

    static final CountDownLatch countDownLatch = new CountDownLatch(10000);

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                new Client().run();
            }
            countDownLatch.await();
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void run() throws IOException {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        try {
            socketChannel.connect(new InetSocketAddress("localhost", 8082), null, new CompletionHandler<Void, Void>() {
                @Override
                public void completed(Void result, Void attachment) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.clear();
                    buffer.put("Hello".getBytes());
                    buffer.flip();
                    socketChannel.write(buffer, null, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            buffer.clear();
                            socketChannel.read(buffer, null, new CompletionHandler<Integer, ByteBuffer>() {
                                @Override
                                public void completed(Integer result, ByteBuffer attachment) {
                                    buffer.flip();
//                                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                                    countDownLatch.countDown();
                                }

                                @Override
                                public void failed(Throwable exc, ByteBuffer attachment) {
                                    throw new RuntimeException(exc);
                                }
                            });
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            throw new RuntimeException(exc);
                        }
                    });
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    throw new RuntimeException(exc);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
