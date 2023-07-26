package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        int tag = 0;
        ListNode temp = head;
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while (temp.next != null) {
            if (map.get(temp) != null) {
                return temp;
            } else {
                map.put(temp, tag++);
            }
            temp = temp.next;
        }
        return null;
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
