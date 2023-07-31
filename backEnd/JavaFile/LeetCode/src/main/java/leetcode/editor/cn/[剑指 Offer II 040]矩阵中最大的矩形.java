package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length(), max = 0;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = matrix[i].charAt(j) - '0';
                if (i != 0) height[i][j] += height[i][j] == 0 ? 0 : height[i - 1][j];
            }
            max = Math.max(largestRectangleArea(height[i]), max);
        }
        return max;
    }


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
