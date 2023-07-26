package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] flag = new int[128];
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            while (right < s.length() && flag[s.charAt(right)] == 0) flag[s.charAt(right++)]++;
            max = Math.max(right - left, max);
            flag[s.charAt(left++)]--;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
