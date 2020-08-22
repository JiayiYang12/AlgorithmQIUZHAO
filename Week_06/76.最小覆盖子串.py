#
# @lc app=leetcode.cn id=76 lang=python3
#
# [76] 最小覆盖子串
#

# @lc code=start
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        import sys
        need, window = [0] * 128, [0] * 128
        for c in t:
            need[ord(c)] += 1
        start, length = 0, sys.maxsize
        left, right, valid = 0, 0, 0
        while right < len(s):
            # 记录最右元素，简化后续引用
            c = s[right]
            # right不再使用，直接往后移动
            right += 1
            # 若当前元素不在目标串中，直接下一个
            if not need[ord(c)]:
                continue
            # 否则，需要确定window中元素个数是否小于need中，若是，则valid++
            if window[ord(c)] < need[ord(c)]:
                valid += 1
            # 只要是目标串中的元素，访问到了，计数都需要++
            window[ord(c)] += 1
            
            while left < len(s) and valid == len(t):
                # 首先判定最优解是否更新
                if right - left < length:
                    start = left
                    length = right - left
                # 重复上一个while的逻辑，即记录当前元素，left指针++，以及无关元素跳过
                d = s[left]
                left += 1
                if not need[ord(d)]:
                    continue
                # 预先判断当前元素是否为关键元素，若是，则在去除掉后，不再满足要求，故valid--
                if window[ord(d)] == need[ord(d)]:
                    valid -= 1
                # 只要是目标串中的元素，被left访问过了，计数都需要--
                window[ord(d)] -= 1
        return "" if length == sys.maxsize else s[start: start + length]
            
# @lc code=end

