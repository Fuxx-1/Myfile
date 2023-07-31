package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
class CBTInserter {

    TreeNode root = null;
    Queue<TreeNode> lackQueue = null;

    public CBTInserter(TreeNode root) {
        this.root = root; // init
        lackQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> ergodicQueue = new LinkedList<TreeNode>();
        ergodicQueue.add(root);
        while (!ergodicQueue.isEmpty()) {
            TreeNode node = ergodicQueue.poll();
            if (node.left == null || node.right == null) lackQueue.add(node);
            if (node.left != null) ergodicQueue.add(node.left);
            if (node.right != null) ergodicQueue.add(node.right);
        }
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        TreeNode lackNode = lackQueue.peek();
        lackQueue.add(newNode);
        if (lackNode.left == null) lackNode.left = newNode;
        else if (lackNode.right == null) lackNode.right = newNode;
        if (lackNode.left != null && lackNode.right != null) lackQueue.poll();
        return lackNode.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
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