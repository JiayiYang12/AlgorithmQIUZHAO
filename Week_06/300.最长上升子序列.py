#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # subproblem: 以第i个数结尾的序列的结果，为前者取最大+1（若第i个数大于前面的数）
        # dp[i] = max(dp[k] for k in range(i-1) if dp[i] > dp[k])
        # dp[i] = 1 for all
        dp = [1] * len(nums)
        if not nums:
            return 0
        res = 1
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
            res = max(res, dp[i])
        return res
        
# @lc code=end

