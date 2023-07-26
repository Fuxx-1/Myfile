package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String res = new String(array);
            if (!map.containsKey(res)) {
                List<String> lists = new ArrayList<>();
                lists.add(strs[i]);
                map.put(res, lists);
            } else {
                map.get(res).add(strs[i]);
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        for (String s : map.keySet()) {
            lists.add(map.get(s));
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
