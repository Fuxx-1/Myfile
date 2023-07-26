package leetcode.editor.cn;

import com.sun.tools.javac.util.StringUtils;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            int diff = s.charAt(i) - s.charAt(len - 1 - i);
            if (diff == 0) {
                continue;
            } else if (diff == 'a' - 'A') {
                if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') continue;
                else return false;
            } else if (diff == 'A' - 'a') {
                if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') continue;
                else return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
