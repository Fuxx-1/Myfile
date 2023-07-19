package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int temp = 0, tempA = a.length(), tempB = b.length();
        while (tempA > 0 || tempB > 0 || temp == 1) {
            int sum = temp;
            if (tempA > 0) sum += a.charAt(--tempA) - '0';
            if (tempB > 0) sum += b.charAt(--tempB) - '0';
            temp = sum / 2;
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
