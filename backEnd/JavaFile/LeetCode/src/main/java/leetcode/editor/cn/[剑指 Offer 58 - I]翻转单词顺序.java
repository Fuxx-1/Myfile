package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ? +");
        StringBuilder result = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            result.append(s1[i]);
            if (i != 0) result.append(" ");
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
