/**
 * <p>A <strong>sentence</strong> is a list of words that are separated by a single space with no leading or trailing spaces. Each of the words consists of <strong>only</strong> uppercase and lowercase English letters (no punctuation).</p>
 *
 * <ul>
 * <li>For example, <code>&quot;Hello World&quot;</code>, <code>&quot;HELLO&quot;</code>, and <code>&quot;hello world hello world&quot;</code> are all sentences.</li>
 * </ul>
 *
 * <p>You are given a sentence <code>s</code>​​​​​​ and an integer <code>k</code>​​​​​​. You want to <strong>truncate</strong> <code>s</code>​​​​​​ such that it contains only the <strong>first</strong> <code>k</code>​​​​​​ words. Return <code>s</code>​​​​<em>​​ after <strong>truncating</strong> it.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;Hello how are you Contestant&quot;, k = 4
 * <strong>Output:</strong> &quot;Hello how are you&quot;
 * <strong>Explanation:</strong>
 * The words in s are [&quot;Hello&quot;, &quot;how&quot; &quot;are&quot;, &quot;you&quot;, &quot;Contestant&quot;].
 * The first 4 words are [&quot;Hello&quot;, &quot;how&quot;, &quot;are&quot;, &quot;you&quot;].
 * Hence, you should return &quot;Hello how are you&quot;.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;What is the solution to this problem&quot;, k = 4
 * <strong>Output:</strong> &quot;What is the solution&quot;
 * <strong>Explanation:</strong>
 * The words in s are [&quot;What&quot;, &quot;is&quot; &quot;the&quot;, &quot;solution&quot;, &quot;to&quot;, &quot;this&quot;, &quot;problem&quot;].
 * The first 4 words are [&quot;What&quot;, &quot;is&quot;, &quot;the&quot;, &quot;solution&quot;].
 * Hence, you should return &quot;What is the solution&quot;.</pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = &quot;chopper is not a tanuki&quot;, k = 5
 * <strong>Output:</strong> &quot;chopper is not a tanuki&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 500</code></li>
 * <li><code>k</code> is in the range <code>[1, the number of words in s]</code>.</li>
 * <li><code>s</code> consist of only lowercase and uppercase English letters and spaces.</li>
 * <li>The words in <code>s</code> are separated by a single space.</li>
 * <li>There are no leading or trailing spaces.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>字符串</li></div></div><br><div><li>👍 48</li><li>👎 0</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < k; i++) {
            if (i != k - 1) {
                temp.append(str[i] + " ");
            } else {
                temp.append(str[i]);
            }
        }
        return temp.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
