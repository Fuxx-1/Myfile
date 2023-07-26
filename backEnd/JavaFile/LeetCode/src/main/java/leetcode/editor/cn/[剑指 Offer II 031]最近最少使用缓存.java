package leetcode.editor.cn;

import org.example.Main;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

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
        ahead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            ahead(node);
            return;
        }
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

    private void ahead(Node node) {
        if (tail == node) tail = node.prev == head ? node : node.prev;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        if (head.next != null) head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
