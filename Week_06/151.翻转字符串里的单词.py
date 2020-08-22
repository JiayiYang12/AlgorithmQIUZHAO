#
# @lc app=leetcode.cn id=151 lang=python3
#
# [151] 翻转字符串里的单词
#

# @lc code=start
class Solution:
    def reverseWords(self, s: str) -> str:
        if not s:
            return ''
        ls = list(s.split())
        return " ".join(reversed(ls))
# @lc code=end

