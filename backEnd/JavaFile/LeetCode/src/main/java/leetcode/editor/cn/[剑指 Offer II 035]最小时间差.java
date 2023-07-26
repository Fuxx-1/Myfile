package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE, len = timePoints.size();
        if (len > 1440) return 0;
        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = getMinutes(timePoints.get(i));
        }
        Arrays.sort(min);
        for (int i = 0; i < len - 1; i++) {
            res = Math.min(min[i + 1] - min[i], res);
        }
        res = Math.min(min[0] - min[len - 1] + 1440, res);
        return res;
    }

    private int getMinutes(String str) {
        return (str.charAt(0) - '0') * 600 + (str.charAt(1) - '0') * 60 + (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
