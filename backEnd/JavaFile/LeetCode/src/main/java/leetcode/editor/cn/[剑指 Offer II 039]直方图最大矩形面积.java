package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, len = heights.length;
        int[] left = new int[len], right = new int[len];
        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && ((i == heights.length) || (heights[stack.peek()] > heights[i]))) {
                right[stack.peek()] = i;
                stack.pop();
            }
            if (i != len) left[i] = (stack.isEmpty() ? 0 : stack.peek() + 1);
            stack.push(i);
        }
        for (int i = 0; i < len; i++) {
            max = Math.max(heights[i] * (right[i] - left[i]), max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
