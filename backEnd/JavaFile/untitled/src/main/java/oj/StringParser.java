package oj;

import java.util.*;

public class StringParser {
    public static void main(String[] args) {
        Character[] arr = new Character[]{'a', 'b', 'c', 'd'};
        LinkedList<Character> word = new LinkedList<>(Arrays.asList(arr));
        String s = "tbcacbdata";
        LinkedList<Character> window = new LinkedList<>();
        int index = 1;
        for (char c : s.toCharArray()) {
            // 如果是word中出现的字母
            if (word.contains(c)) {
                // 首先移动windows到重复字母之后
                if (window.contains(c)) {
                    while (window.pollFirst() != c) ;
                }
                window.add(c);
                // 判断是否存在答案
                if (window.size() == word.size()) {
                    System.out.println(index - word.size());
                    return;
                }
            }
            // 不是 word中的字母
            else {
                window.clear();
            }
            index++;
        }
    }
}