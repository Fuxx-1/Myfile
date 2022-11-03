package org.example.leetcode.editor.cn;//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 
// 👍 1836 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

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
    //    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode hair = new ListNode(-1, head);
//        ListNode prev = hair;
//        while (true) {
//            ListNode last = prev;
//            // 检测节点是否充足
//            for (int i = 0; i < k; i++) {
//                last = last.next;
//                if (last == null) {
//                    return hair.next;
//                }
//            }
//            // 开始翻转
//            ListNode curr = prev.next.next, next = null;
//            curr.next = last.next;
//            for (int i = 0; i < k - 1; i++) {
//                next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//            prev = next;
//        }
//    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(-1, head), begin = hair, end = hair;
        int numbers = 0;
        while (end.next != null) {
            end = end.next;
            numbers++;
            if (numbers == k) {
                Reverse(begin.next, end);
                begin.next = end;
                
                numbers = 0;
            }
        }
        return hair.next;
    }

    public void Reverse(ListNode begin, ListNode end) {
        if (begin == end) {
            return;
        }
        ListNode mid = begin.next, temp;
        begin.next = end.next;
        while (mid != end) {
            temp = mid.next;
            mid.next = begin;
            begin = mid;
            mid = temp;
        }
        end.next = begin;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

class ListNode {
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

class Test {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        ListNode head = new ListNode(0, null);
        for (int i : a) {
            head.next = new ListNode(i, head.next);
        }
        Solution solution = new Solution();
        print(head);
        head = solution.reverseKGroup(head, 3);
        print(head);
    }

    public static void print(ListNode head) {
        System.out.print(head.val);
        while (head.next != null) {
            head = head.next;
            System.out.print(head.val);
        }
    }
}