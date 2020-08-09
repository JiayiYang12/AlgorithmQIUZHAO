/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        // 状态数组：dp[i], 
        // dp equation: '(': 0, ')': i-1:'('; i-1:')';
        int[] dp = new int [n];
        if (n == 0 || s == null) return res;
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2? dp[i-2]: 0) + 2;
                }
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    // dp[i] = 自身构成的单一括号对 + 单一括号对之内的元素的个数 + 匹配的左括号的左边的有效括号长度
                    dp[i] = 2 + dp[i - 1] + (i - dp[i-1] >= 2? dp[i - dp[i - 1] - 2]: 0);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;

    }
}
// @lc code=end

