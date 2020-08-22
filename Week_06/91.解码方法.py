#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#

# @lc code=start
class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == '0':
            return 0
        n = len(s)
        dp = [0] * n
        dp[0] = 1
        for i in range(1, n):
            if s[i] != '0':
                dp[i] += dp[i-1]
            num = 10 * int(s[i-1]) + int(s[i])
            if 10 <= num <= 26:
                if i == 1:
                    dp[i] += 1
                else:
                    dp[i] += dp[i-2]
        return dp[-1]
# @lc code=end

