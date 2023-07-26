package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            char start = s.charAt(i), end = s.charAt(len - i - 1);
            if (start == end) continue;
            if (s.charAt(i + 1) == end || start == s.charAt(len - i - 2))
                return isPalindromicString(s, i + 1, len - i - 1) || isPalindromicString(s, i, len - i - 2);
            return false;
        }
        return true;
    }

    public boolean isPalindromicString(String str, int start, int end) {
        if (end < start) return false;
        while (start <= end) if (str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
