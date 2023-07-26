package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node b = flatten(node.child), d = node.next;
                Node c = b;
                node.child = null;
                while (c.next != null)  c = c.next;
                node.next = b;
                b.prev = node;
                c.next = d;
                if (d != null) d.prev = c;
            }
            node = node.next;
        }
        return head;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};