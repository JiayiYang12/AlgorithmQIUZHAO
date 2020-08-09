/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        char[] charword1 = word1.toCharArray();
        char[] charword2 = word2.toCharArray();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i ++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i ++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                // 遍历两个字符串的所有字节
                if (charword1[i] == charword2[j]) {
                    dp[i+1][j+1] = dp[i][j];
                }
                else {
                    int replace = dp[i][j] + 1;
                    int delete = dp[i][j+1] + 1;
                    int insert = dp[i+1][j] + 1;
                    dp[i+1][j+1] = Math.min(Math.min(replace, delete), insert);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

