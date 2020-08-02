/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i ++;
                res ++;
            }
            j ++;
        }
        return res;
    }
}
// @lc code=end

