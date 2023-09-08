package org.example;

import java.util.UUID;

public class nanoid {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(NanoIdUtils.randomNanoId());
        }
    }
}
