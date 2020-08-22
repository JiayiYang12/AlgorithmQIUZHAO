#
# @lc app=leetcode.cn id=493 lang=python3
#
# [493] 翻转对
#

# @lc code=start
class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        return self.mergesort(nums, 0, len(nums) - 1)
    
    def mergesort(self, a, begin, end):
        if begin >= end:
            return 0
        mid = (begin + end) >> 1
        cnt = self.mergesort(a, begin, mid) + self.mergesort(a, mid + 1, end)
        for lt in range(begin, mid+1):
            rt = mid + 1
            while rt <= end and a[lt] / 2.0 > a[rt]:
                rt += 1
            cnt += rt - mid - 1
        self.merge(a, begin, mid, end)
        # a[begin: end+1].sort()
        return cnt
    
    def merge(self, a, begin, mid, end):
        lt, rt = begin, mid + 1
        tmp = []
        while lt <= mid or rt <= end:
            if lt > mid or (rt <= end and a[rt] < a[lt]):
                tmp.append(a[rt])
                rt += 1
            else:
                tmp.append(a[lt])
                lt += 1
        a[begin: end + 1] = tmp
        
# @lc code=end

