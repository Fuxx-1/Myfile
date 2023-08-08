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
    TreeNode minNode = new TreeNode(Integer.MAX_VALUE);
    public TreeNode increasingBST(TreeNode root) {
        dfs(root, null);
        return minNode;
    }

    public TreeNode dfs(TreeNode root, TreeNode prev) {
        if (root == null) return null;
        if (root.left != null) {
            dfs(root.left, root);
            if (root.left.val < minNode.val) minNode = root.left;
            root.left.right = root;
            root.left = null;
        }
        if (root.right != null) {
            dfs(root.right, root);
        }
        return null;
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