package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        int flag = 0;
        stack.push(flag);
        while (++flag < temperatures.length) {
            while (!stack.isEmpty() && temperatures[flag] > temperatures[stack.peek()]) {
                res[stack.peek()] = flag - stack.peek();
                stack.pop();
            }
            stack.push(flag);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
