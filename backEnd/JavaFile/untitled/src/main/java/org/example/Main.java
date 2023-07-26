package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(1);
    }


    static class LRUCache {

        Node head = null;   // used to insert
        Node tail = null;   // used to delete
        int size;           // used to calculate the size
        int capacity;
        Map<Integer, Node> map;

        static class Node {
            Integer key;
            Integer value;
            Node next;
            Node prev;

            public Node(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }

            public Node(Integer key, Integer value, Node prev, Node next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }

        public LRUCache(int capacity) {
            head = tail = new Node(null, null, null, null);
            size = 0;
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            if (tail == node) tail = node.prev == head ? node : node.prev;
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            node.next = head.next;
            node.prev = head;
            if (head.next != null) head.next.prev = node;
            head.next = node;
            return node.value;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key, value, head, head.next);
            if (head.next != null) head.next.prev = newNode;
            else tail = newNode;
            map.put(key, newNode);
            head.next = newNode;
            if (size == capacity) {
                //delete LRU Node
                map.remove(tail.key);
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
            } else {
                size++;
            }
        }
    }
}