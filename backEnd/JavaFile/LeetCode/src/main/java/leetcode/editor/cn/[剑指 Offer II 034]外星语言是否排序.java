package leetcode.editor.cn;

import com.sun.tools.javac.util.StringUtils;

import java.util.Arrays;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] skew = new int[26];
        for (int i = 0; i < order.length(); i++) {
            skew[order.charAt(i) - 'a'] += i + 1;
        }
        System.out.println(Arrays.toString(skew));
        for (int i = 0; i < words.length - 1; i++) {
            String left = words[i], right = words[i + 1];
            if (left.equals(right)) continue;
            int min = Math.min(left.length(), right.length());
            for (int j = 0; j < min; j++) {
                if (skew[left.charAt(j) - 'a'] < skew[right.charAt(j) - 'a']) break;
                if (skew[left.charAt(j) - 'a'] > skew[right.charAt(j) - 'a']) return false;
                if (j == min - 1 && left.length() > right.length()) return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
