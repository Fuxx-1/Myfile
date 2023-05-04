package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.regex.Pattern;
class Solution {
    public boolean isNumber(String s) {
        return Pattern.matches(" *(([+-]?(\\d+\\.\\d*|\\.\\d+))|[+-]?\\d+)([Ee][+-]?\\d+)? *", s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
