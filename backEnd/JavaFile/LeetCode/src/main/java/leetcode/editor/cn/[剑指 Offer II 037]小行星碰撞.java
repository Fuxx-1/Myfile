package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroids[i])) {
                    while (stack.peek() > 0 && stack.peek() <= Math.abs(asteroids[i])) {
                        if (stack.peek() == Math.abs(asteroids[i])) {
                            stack.pop();
                            break;
                        } else if (stack.peek() < Math.abs(asteroids[i])) {
                            stack.pop();
                        }
                        if (stack.isEmpty() || stack.peek() < 0) stack.push(asteroids[i]);
                    }
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
