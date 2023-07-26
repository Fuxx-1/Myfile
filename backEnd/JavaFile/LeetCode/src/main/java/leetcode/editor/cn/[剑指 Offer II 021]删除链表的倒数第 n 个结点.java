package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quickNode = head, slowNode = head;
        for (int i = 0; i < n; i++) {
            if (quickNode.next != null) quickNode = quickNode.next;
            else return head.next;
        }
        while (quickNode.next != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        if (slowNode.next != null) slowNode.next = slowNode.next.next;
        return head;
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
