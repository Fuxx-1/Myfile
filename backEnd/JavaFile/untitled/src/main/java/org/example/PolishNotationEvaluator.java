package org.example;

//package org.example;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//
//
//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        lruCache.get(1);
//    }
//
//
//    static class LRUCache {
//
//        Node head = null;   // used to insert
//        Node tail = null;   // used to delete
//        int size;           // used to calculate the size
//        int capacity;
//        Map<Integer, Node> map;
//
//        static class Node {
//            Integer key;
//            Integer value;
//            Node next;
//            Node prev;
//
//            public Node(Integer key, Integer value) {
//                this.key = key;
//                this.value = value;
//            }
//
//            public Node(Integer key, Integer value, Node prev, Node next) {
//                this.key = key;
//                this.value = value;
//                this.prev = prev;
//                this.next = next;
//            }
//        }
//
//        public LRUCache(int capacity) {
//            head = tail = new Node(null, null, null, null);
//            size = 0;
//            this.capacity = capacity;
//            map = new HashMap<>(capacity);
//        }
//
//        public int get(int key) {
//            if (!map.containsKey(key)) return -1;
//            Node node = map.get(key);
//            if (tail == node) tail = node.prev == head ? node : node.prev;
//            if (node.prev != null) node.prev.next = node.next;
//            if (node.next != null) node.next.prev = node.prev;
//            node.next = head.next;
//            node.prev = head;
//            if (head.next != null) head.next.prev = node;
//            head.next = node;
//            return node.value;
//        }
//
//        public void put(int key, int value) {
//            Node newNode = new Node(key, value, head, head.next);
//            if (head.next != null) head.next.prev = newNode;
//            else tail = newNode;
//            map.put(key, newNode);
//            head.next = newNode;
//            if (size == capacity) {
//                //delete LRU Node
//                map.remove(tail.key);
//                tail = tail.prev;
//                tail.next.prev = null;
//                tail.next = null;
//            } else {
//                size++;
//            }
//        }
//    }
//}
//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println(findMin(new int[] {4, 5, 0, 1, 2, 3}));
//    }
//
//    public static int findMin(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left < right) {
//            if (nums[left] < nums[right]) {
//                // 如果[left, right]区间是升序的，直接返回left指向的元素
//                return nums[left];
//            }
//
//            int mid = (left + right) / 2;
//            if (nums[left] <= nums[mid]) {
//                // 如果[left, mid]区间是升序的，最小值在[mid+1, right]区间内
//                left = mid + 1;
//            } else {
//                // 如果[mid+1, right]区间是升序的，最小值在[left, mid]区间内
//                right = mid;
//            }
//        }
//
//        // 最终left指向的元素就是最小值
//        return nums[left];
//    }
//}

import java.util.Stack;

public class PolishNotationEvaluator {
    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "* + 2 3 4";
        int result = evaluate(expression);
        System.out.println("Result: " + result);
    }
}