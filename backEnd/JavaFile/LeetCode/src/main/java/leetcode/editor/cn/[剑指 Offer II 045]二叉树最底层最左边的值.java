package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxHeight = -1;
    int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }

    public void dfs(TreeNode node, int height) {
        if (node == null) return;
        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
        if (maxHeight < height) {
            maxHeight = height;
            value = node.val;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}