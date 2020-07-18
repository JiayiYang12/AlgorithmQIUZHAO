/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] map = new int [26];
        for (int i = 0; i < s.length(); i ++) {
            map[s.charAt(i) - 'a'] ++;
            map[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }
}
// @lc code=end

