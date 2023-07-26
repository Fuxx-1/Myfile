package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (isNumber(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int b = stack.pop(), a = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String str) {
        return !(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
