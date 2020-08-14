#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        self.n = n
        self.dfs(0, 0, 0, 0, []) 
        
        return [['.'*alp + 'Q' + '.' * (n-1-alp) for alp in sub_res] for sub_res in self.res]
        
    def dfs(self, row, cols, pie, na, cur_res):
        # terminator
        if self.n == row:
            self.res.append(cur_res)
            return
        
        # process current logic
        bits = (~(cols | pie | na)) & ((1 << self.n) - 1)
        while bits:
            pos = bits & -bits # 保留最低位1
            # 计算存放的列
            tmp = pos
            cnt = 0
            while tmp & 1 == 0:
                tmp >>= 1
                cnt += 1
            bits &= (bits - 1) # 将最低位1为清零
            
            # drill down
            self.dfs(row+1, cols | pos, (pie | pos) << 1, (na | pos) >> 1, cur_res + [cnt])
        
    
                
# @lc code=end

