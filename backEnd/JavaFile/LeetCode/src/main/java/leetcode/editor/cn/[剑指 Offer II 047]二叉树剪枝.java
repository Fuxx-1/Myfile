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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        dfs(root);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        if (root.left != null && !dfs(root.left)) {
            root.left = null;
        }
        if (root.right != null && !dfs(root.right)) {
            root.right = null;
        }
        System.out.println(root.val == 1 || root.left != null && dfs(root.left) || root.right != null && dfs(root.right));
        return root.val == 1 || root.left != null && dfs(root.left) || root.right != null && dfs(root.right);
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