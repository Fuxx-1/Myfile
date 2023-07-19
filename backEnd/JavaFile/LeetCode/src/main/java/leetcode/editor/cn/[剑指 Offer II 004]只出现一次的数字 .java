package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (b & num) | (a & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
