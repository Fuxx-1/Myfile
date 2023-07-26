package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        int[] flag = new int[128];
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i)]++;
            flag[t.charAt(i)]--;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] != 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
