#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        queue = []
        queue.append(("", n, n))
        while queue:
            cur_s, cur_lt, cur_rt = queue.pop()
            
            if cur_lt == cur_rt == 0:
                res.append(cur_s)
            
            if cur_lt > 0:
                queue.append((cur_s + '(', cur_lt -1, cur_rt))
            if cur_rt > cur_lt:
                queue.append((cur_s + ')', cur_lt, cur_rt - 1))
        return res
        
# @lc code=end

