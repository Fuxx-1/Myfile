package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[words.length];
        for (var i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        for (var i = 0; i < words.length; i++) {
            for (var j = 0; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
