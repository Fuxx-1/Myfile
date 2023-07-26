package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal), temp = head;
        if (temp == null) {
            node.next = node;
            return node;
        }
        if (temp.next == temp) {
            temp.next = node;
            node.next = temp;
            return temp;
        }
        for (int i = 0; i == 0 || temp != head; i++) {
            if ((temp.val <= temp.next.val && temp.val <= insertVal && insertVal <= temp.next.val) || (temp.val > temp.next.val && (temp.val < insertVal || insertVal < temp.next.val))) {
                node.next = temp.next;
                temp.next = node;
                return head;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        return head;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};