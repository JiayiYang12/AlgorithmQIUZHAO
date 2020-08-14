#
# @lc app=leetcode.cn id=433 lang=python3
#
# [433] 最小基因变化
#

# @lc code=start
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if end not in bank:
            return -1
        front = [start]
        back = [end]
        wordset = set(bank)
        wordset.remove(end)
        res = 1
        
        
        while front:
            size = len(front)
            for i in range(size):
                word = front.pop()
                for i in range(len(word)):
                    for c in ['A', 'G', 'C', 'T']:
                        if c is not word[i]:
                            nextword = word[: i] + c + word[i+1: ]
                            if nextword in back:
                                return res
                            if nextword in wordset:
                                front.append(nextword)
                                wordset.remove(nextword)
            if len(front) > len(back):
                front, back = back, front
            res += 1
        
        return -1
                            
# @lc code=end

