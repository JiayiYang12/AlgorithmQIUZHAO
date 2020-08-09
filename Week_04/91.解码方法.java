/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < n; i ++) {
            // dp[i-1]
            if (charArray[i] != '0') dp[i] += dp[i-1];
            // dp[i-2]
            int num = 10 * (charArray[i-1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i] ++;
                }
                else {
                    dp[i] += dp[i-2];
                }
                
            }

        }
        return dp[n-1];

    }
}
// @lc code=end

