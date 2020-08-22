#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        if not intervals:
            return res
        intervals.sort(key = lambda x: x[0])
        res.append(intervals[0])
        for item in intervals[1: ]:
            if item[0] <= res[-1][1]:
                prev = res.pop()
                res.append([prev[0], max(prev[1], item[1])])
            else:
                res.append(item)
        return res
# @lc code=end

