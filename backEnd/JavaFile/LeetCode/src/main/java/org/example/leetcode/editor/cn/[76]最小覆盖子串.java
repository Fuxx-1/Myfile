//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 2215 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        String answer = null;
        if (t.length() > s.length()) {
            return "";
        } else {
            Map<Character, Integer> tMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                if (tMap.get(c) == null) {
                    tMap.put(c, 1);
                } else {
                    tMap.put(c, tMap.get(c) + 1);
                }
            }
            for (int i = 0; i <= s.length() - t.length(); i++) {
                Map<Character, Integer> sMap = new HashMap<>();
                char c = s.charAt(i);
                if (tMap.containsKey(c)) {
                    //放入Map
                    if (sMap.get(c) == null) {
                        sMap.put(c, 1);
                    } else {
                        sMap.put(c, sMap.get(c) + 1);
                    }
                    //检查是否满足条件
                    boolean checked = check(sMap, tMap);
                    if (checked) {
                        while (!tMap.containsKey(s.charAt(left))) {
                            left++;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public boolean check(Map<Character, Integer> now, Map<Character, Integer> need) {
        for (Character c : need.keySet()) {
            if (now.get(c) < need.get(c)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
