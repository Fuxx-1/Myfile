package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        String res = "";
        int[] flag = new int[64];
        int tLen = t.length(), sLen = s.length(), l = 0, r = 0;
        for (int i = 0; i < tLen; i++) flag[t.charAt(i) - 'A']++;
        while (r < sLen) {
            while (r < sLen && !isSatisfy(flag)) {
                flag[s.charAt(r++) - 'A']--;
            }
            if (!isSatisfy(flag)) break;
            while (l < r && isSatisfy(flag)) {
                flag[s.charAt(l++) - 'A']++;
            }
            flag[s.charAt(--l) - 'A']--;
            if (res.length() == 0 || res.length() > r - l) res = s.substring(l, r);
            flag[s.charAt(l++) - 'A']++;
        }
        return res;
    }

    public boolean isSatisfy(int[] flag) {
        boolean res = true;
        for (int i = 0; i < flag.length; i++) {
            res = flag[i] <= 0 && res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
