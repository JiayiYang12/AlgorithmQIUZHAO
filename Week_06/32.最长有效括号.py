#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        # subproblem: 
        # dp[n]
        # 2
        
        dp = [0] * len(s)
        res = 0
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    if i == 1:
                        dp[i] = 2
                    else:
                        dp[i] = dp[i-2] + 2
                elif i >= dp[i-1] + 1 and s[i - dp[i-1] - 1] == '(':
                    dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2 if i > dp[i-1] + 1 else dp[i-1] + 2
            res = max(res, dp[i])
        return res
        
# @lc code=end

