#
# @lc app=leetcode.cn id=541 lang=python3
#
# [541] 反转字符串 II
#

# @lc code=start
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res = []
        for i in range(0, len(s), 2 * k):
            if i + k < len(s):
                res.append(''.join(reversed(s[i: i+k])))
                if i + 2*k < len(s):
                    res.append(''.join(s[i+k: i+2*k]))
                else:
                    res.append(''.join(s[i+k: ]))
            else:
                res.append(''.join(reversed(s[i: ])))
        return ''.join(res)
# @lc code=end

