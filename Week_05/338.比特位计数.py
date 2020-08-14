#
# @lc app=leetcode.cn id=338 lang=python3
#
# [338] 比特位计数
#

# @lc code=start
class Solution:
    def countBits(self, num: int) -> List[int]:
        dp = [0] * (num+1)
        for i in range(1, num+1):
            dp[i] = dp[i >> 1] + (i & 1)
        return dp
        
        
# @lc code=end

