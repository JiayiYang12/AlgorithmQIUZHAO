#
# @lc app=leetcode.cn id=818 lang=python3
#
# [818] 赛车
#

# @lc code=start
class Solution(object):
    def racecar(self, target):
        dp = [0, 1, 4] + [float('inf')] * (target - 2)
        for t in range(3, target + 1):
            k = t.bit_length()
            if t == 2**k - 1:
                dp[t] = k 
                continue
            for j in range(k - 1):
                # 迂回，其中‘t - 2**(k - 1) + 2**j’表示从迂回点到t的距离，这个距离之前已经计算过了，这里拿来使用
                # min的第二部分的理解：到t的距离 = 到迂回点的指令最小数 + 迂回点到t的距离的指令最小数
                dp[t] = min(dp[t], dp[t - 2**(k - 1) + 2**j] + k - 1 + j + 2) 
            if 2**k - 1 - t > 0:
                # 超出后一次性返回，其中‘2**k - 1 - t’表示从超出点到t的距离
                # min的第二部分的理解：到t的距离 = 到超出点的指令最小数 + 超出点到t的距离的指令最小数
                dp[t] = min(dp[t], dp[2**k - 1 - t] + k + 1)
        return dp[target]

# @lc code=end

