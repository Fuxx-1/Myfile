package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> right = new ArrayList<>();
    int maxHeight = -1;

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return right;
    }

    public void dfs(TreeNode treeNode, int height) {
        if (treeNode == null) return;
        if (height > maxHeight) {
            maxHeight = height;
            right.add(treeNode.val);
        }
        dfs(treeNode.right, height + 1);
        dfs(treeNode.left, height + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }