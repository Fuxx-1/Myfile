package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) return list;
        int[] flag1 = new int[26];
        int[] flag2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            flag1[p.charAt(i) - 'a']++;
            if (i != p.length() - 1) flag2[s.charAt(i) - 'a']++;
        }
        for (int i = p.length() - 1, a = 0; i < s.length(); i++) {
            flag2[s.charAt(i) - 'a']++;
            if (Arrays.equals(flag1, flag2)) list.add(i - p.length() + 1);
            flag2[s.charAt(a++) - 'a']--;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
