package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode temp = head.next;
        Deque<ListNode> deque = new LinkedList<ListNode>();
        while (temp != null) {
            deque.addFirst(temp);
            temp = temp.next;
        }
        temp = head;
        while (!deque.isEmpty()) {
            if (!deque.isEmpty()) {
                temp.next = deque.pollFirst();
                temp = temp.next;
            }
            if (!deque.isEmpty()) {
                temp.next = deque.pollLast();
                temp = temp.next;
            }
        }
        temp.next = null;
        return;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}