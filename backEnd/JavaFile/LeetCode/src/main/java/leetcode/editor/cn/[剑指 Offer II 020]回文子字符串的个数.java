package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), res = 0;
        for (int i = 0; i < len; i++) {
            res += extend(s, i, i); // i
            if (i != len - 1) res += extend(s, i, i + 1); // i + 0.5
        }
        return res;
    }

    public int extend(String s, int start, int end) {
        int res = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) res++;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
