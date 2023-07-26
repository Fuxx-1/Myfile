package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] flag1 = new int[26];
        int[] flag2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            flag1[s1.charAt(i) - 'a']++;
            if (i != s1.length() - 1) flag2[s2.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(flag1));
        for (int i = s1.length() - 1, a = 0; i < s2.length(); i++) {
            flag2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(flag1, flag2)) return true;
            flag2[s2.charAt(a++) - 'a']--;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
