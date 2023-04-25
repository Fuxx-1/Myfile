package org.example.Another;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 14:18
 */
public class TheMaxLengthTree {

    private static int max;

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2, new Node(4, new Node(41, new Node(51), new Node(52)), null), new Node(5, new Node(42, null, new Node(53)), null));
        head.right = new Node(3);
        max = 0;
        int result = getMaxLength(head);
        System.out.println(max);
    }

    private static int getMaxLength(Node root) {

        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = getMaxLength(root.left);
        }
        if (root.right != null) {
            right = getMaxLength(root.right);
        }
        max = Math.max(left + right + 3, max);
        return Math.max(left, right) + 1;
    }

}
