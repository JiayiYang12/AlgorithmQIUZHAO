#
# @lc app=leetcode.cn id=130 lang=python3
#
# [130] 被围绕的区域
#

# @lc code=start
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        class UnionFind:
            def __init__(self, n):
                self.p = [i for i in range(n)]
                
            def find(self, i):
                root = i
                while root != self.p[root]:
                    root = self.p[root]
                while i != self.p[i]:
                    x = i; i = self.p[i]; self.p[x] = root;
                return root
            
            def union(self, i, j):
                p1 = self.find(i)
                p2 = self.find(j)
                if p1 != p2:
                    self.p[p1] = p2
                
            def isConnected(self, i, j):
                # return self.p[i] == self.p[j]
                return self.find(self.p[i]) == self.find(self.p[j])
        
        rows = len(board)
        if not rows:
            return
        cols = len(board[0])
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        
        uf = UnionFind(rows * cols + 1)
        dummyNode = rows * cols
        
        def pos(i, j):
            return i * cols + j
        
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 'O':
                    if i == 0 or i == rows - 1 or j == 0 or j == cols - 1:
                        uf.union(pos(i, j), dummyNode)
                    else:
                        for dirc in directions:
                            new_i = i + dirc[0]
                            new_j = j + dirc[1]
                            if board[new_i][new_j] =='O':
                                uf.union(pos(new_i, new_j), pos(i, j))
                                
        
        for i in range(rows):
            for j in range(cols):
                if uf.isConnected(pos(i, j), dummyNode):
                    continue
                else:
                    board[i][j] = 'X'
                                    
# @lc code=end

