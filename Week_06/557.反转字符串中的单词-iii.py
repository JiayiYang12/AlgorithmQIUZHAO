#
# @lc app=leetcode.cn id=557 lang=python3
#
# [557] 反转字符串中的单词 III
#

# @lc code=start
class Solution:
    def reverseWords(self, s: str) -> str:
        ls = list(s.split())
        res = []
        for c in ls:
            res.append("".join(reversed(c)))
        return " ".join(res)
# @lc code=end

