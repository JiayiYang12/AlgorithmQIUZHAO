#
# @lc app=leetcode.cn id=917 lang=python3
#
# [917] 仅仅反转字母
#

# @lc code=start
class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        stk, res = [], []
        for c in s:
            if c.isalpha():
                stk.append(c)
        for c in s:
            if c.isalpha():
                res.append(stk.pop())
            else:
                res.append(c)
        return ''.join(res)
# @lc code=end

