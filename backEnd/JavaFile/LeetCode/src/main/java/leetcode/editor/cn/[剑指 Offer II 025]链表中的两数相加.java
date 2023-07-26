package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int tempValue = 0;
        ListNode tempListNode = null;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        while (!stack1.empty() || !stack2.empty() || tempValue != 0) {
            if (!stack1.empty()) tempValue += stack1.pop();
            if (!stack2.empty()) tempValue += stack2.pop();
            ListNode newListNode = new ListNode(tempValue % 10, tempListNode);
            tempValue /= 10;
            tempListNode = newListNode;
        }
        return tempListNode;
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