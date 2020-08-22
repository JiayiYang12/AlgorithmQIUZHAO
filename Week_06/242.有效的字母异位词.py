#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        map = [0] * 26
        for c in s:
            map[ord(c) - 97] += 1
        for c in t:
            map[ord(c) - 97] -= 1
        return any(map) == 0
# @lc code=end

