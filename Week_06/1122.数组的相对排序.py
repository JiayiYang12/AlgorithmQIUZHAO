#
# @lc app=leetcode.cn id=1122 lang=python3
#
# [1122] 数组的相对排序
#

# @lc code=start
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        cnt = [0] * 1001
        res = []
        for n in arr1:
            cnt[n] += 1
        for n in arr2:
            while cnt[n] != 0:
                res.append(n)
                cnt[n] -= 1
        for i in range(len(cnt)):
            while cnt[i] != 0:
                res.append(i)
                cnt[i] -= 1
        return res
# @lc code=end

