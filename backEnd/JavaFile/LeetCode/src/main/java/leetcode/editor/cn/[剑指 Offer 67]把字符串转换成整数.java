package leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)

import java.math.BigInteger;

class Solution {
    public int strToInt(String str) {
        boolean isBelow = false;
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < str.length() && str.charAt(index) == ' ') index++;
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
            isBelow = str.charAt(index++) == '-';
        while (index < str.length() && '0' <= str.charAt(index) && str.charAt(index) <= '9') {
            result.append(str.charAt(index++));
        }
        BigInteger bigInteger = BigInteger.valueOf(0);
        if (result.length() > 0) bigInteger = new BigInteger(result.toString());
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 || bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            if (isBelow) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        } else {
            if (isBelow) return bigInteger.intValue() * -1;
            return bigInteger.intValue();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
