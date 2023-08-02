package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize0(root, new StringBuilder()).toString();
    }

    private StringBuilder serialize0(TreeNode root, StringBuilder res) {
        if (root == null) return res.append(",null");
        res.append("," + root.val);
        serialize0(root.left, res);
        serialize0(root.right, res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataStrSplit = data.split(",");
        LinkedList<Integer> nodes = Arrays.stream(dataStrSplit)
                .filter(s -> s.length() != 0)
                .map(s -> s.equals("null") ? null : Integer.parseInt(s))
                .collect(Collectors.toCollection(LinkedList::new));
        return deserialize0(nodes);
    }

    public TreeNode deserialize0(LinkedList<Integer> nodes) {
        if (nodes.getFirst() == null) {
            nodes.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(nodes.removeFirst());
        root.left = deserialize0(nodes);
        root.right = deserialize0(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}