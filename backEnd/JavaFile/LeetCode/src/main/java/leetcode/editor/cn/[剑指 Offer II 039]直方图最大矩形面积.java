package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int cyc = 0, max = 0;
        while (cyc < heights.length) {
            stack.push(cyc++);
            while (!stack.isEmpty() && ((cyc == heights.length) || (heights[stack.peek()] > heights[cyc]))) {
                max = Math.max(heights[stack.peek()] * (cyc - stack.peek()), max);
                stack.pop();
            }
        }
        System.out.println(stack.size());
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
