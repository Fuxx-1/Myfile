//package org.example.leetcode.editor.cn;
//
//import java.util.*;
////给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
////
////
////
//// 示例 1：
////
////
////输入：root = [3,9,20,null,null,15,7]
////输出：[[3],[20,9],[15,7]]
////
////
//// 示例 2：
////
////
////输入：root = [1]
////输出：[[1]]
////
////
//// 示例 3：
////
////
////输入：root = []
////输出：[]
////
////
////
////
//// 提示：
////
////
//// 树中节点数目在范围 [0, 2000] 内
//// -100 <= Node.val <= 100
////
////
//// Related Topics 树 广度优先搜索 二叉树
//// 👍 708 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode() {}
// * TreeNode(int val) { this.val = val; }
// * TreeNode(int val, TreeNode left, TreeNode right) {
// * this.val = val;
// * this.left = left;
// * this.right = right;
// * }
// * }
// */
//class Solution {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        boolean isLeft = true;
//        if (root != null) queue.offer(root);
//        while (!queue.isEmpty()) {
//            Deque<Integer> floorAns = new LinkedList<>();
//            int size = queue.size();
//            while (size-- > 0) {
//                TreeNode temp = queue.poll();
//                if (isLeft) {
//                    floorAns.offerLast(temp.val);
//                } else {
//                    floorAns.offerFirst(temp.val);
//                }
//                if (temp.left != null) queue.offer(temp.left);
//                if (temp.right != null) queue.offer(temp.right);
//            }
//            result.add(new ArrayList<>(floorAns));
//            isLeft = !isLeft;
//        }
//        return result;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
