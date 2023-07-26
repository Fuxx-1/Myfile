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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<Integer>();
        while (head != null) {
            deque.addFirst(head.val);
            head = head.next;
        }
        while (deque.size() > 1) {
            if (deque.pollFirst() == deque.pollLast()) continue;
            else return false;
        }
        return true;
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