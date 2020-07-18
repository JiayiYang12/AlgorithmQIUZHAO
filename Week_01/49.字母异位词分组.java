import java.awt.List;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        HashMap<String, List> res = new HashMap<>();
        for (String s: strs) {
            char [] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!res.containsKey(key)) res.put(key, new ArrayList());
            res.get(key).add(s);
        }
        return new ArrayList(res.values());


    }
}
// @lc code=end

