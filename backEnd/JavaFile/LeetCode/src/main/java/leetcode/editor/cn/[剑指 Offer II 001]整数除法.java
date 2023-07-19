package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int a, int b) {
        if (a == 0 || b == 1) {
            return a;
        } else if (b == -1) {
            return a == Integer.MIN_VALUE ? Integer.MAX_VALUE : -a;
        }
        int max = 0, res = 0, tempA = -Math.abs(a), tempB = -Math.abs(b);
        while (tempA - (tempB << max) <= tempB << max) max++;
        for (int i = max + 1; i >= 0; i--) {
            if (tempA <= tempB << i && tempB << i < 0) {
                tempA -= tempB << i;
                res += 1 << i;
            }
        }
        return (a ^ b) < 0 ? -res : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
