////给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
////
//// 换句话说，s1 的排列之一是 s2 的 子串 。
////
////
////
//// 示例 1：
////
////
////输入：s1 = "ab" s2 = "eidbaooo"
////输出：true
////解释：s2 包含 s1 的排列之一 ("ba").
////
////
//// 示例 2：
////
////
////输入：s1= "ab" s2 = "eidboaoo"
////输出：false
////
////
////
////
//// 提示：
////
////
//// 1 <= s1.length, s2.length <= 10⁴
//// s1 和 s2 仅包含小写字母
////
////
//// Related Topics 哈希表 双指针 字符串 滑动窗口
//// 👍 780 👎 0
//
//
//import java.util.HashMap;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//        if (s2.length() < s1.length()) {
//            return false;
//        }
//        int left = 0;
//        HashMap<Character, Integer> s1Map = new HashMap<>(32);
//        // 生成s1字符串字符统计Map
//        for (int i = 0; i < s1.length(); i++) {
//            Character c = s1.charAt(i);
//            if (s1Map.containsKey(c)) {
//                s1Map.put(c, s1Map.get(c) + 1);
//            } else {
//                s1Map.put(c, 1);
//            }
//        }
//        // 根据s1字符串字符统计Map判断s2字符串是否符合要求
//        HashMap<Character, Integer> s2Map = new HashMap<>(32);
//        for (int i = 0; i < s2.length(); i++) {
//            Character c = s2.charAt(i);
//            if (s1Map.containsKey(c)) {
//                if (s2Map.containsKey(c)) {
//                    s2Map.put(c, s2Map.get(c) + 1);
//                } else {
//                    s2Map.put(c, 1);
//                }
//            } else {
//                left = i + 1;
//                s2Map.clear();
//            }
//            while (i - left + 1 >= s1.length()) {
//                if (s2Map.equals(s1Map)) {
//                    return true;
//                }
//                char ch = s2.charAt(left);
//                if (s2Map.containsKey(ch)) {
//                    s2Map.put(ch, s2Map.get(ch) - 1);
//                    left++;
//                }
//            }
//        }
//        return false;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//
//class Test {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.checkInclusion("adc", "dcda"));
//    }
//}