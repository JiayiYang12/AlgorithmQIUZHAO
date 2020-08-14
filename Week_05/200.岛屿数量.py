#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:     
    
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        if not rows:
            return 0
        cols = len(grid[0])
        
        class UnionFind:
            def __init__(self, n):
                self.p = [i for i in range(n)]
                self.res = n
            
            def find(self, i):
                root = i
                while root != self.p[root]:
                    root = self.p[root]
                return root
            
            def union(self, i, j):
                p1 = self.find(i)
                p2 = self.find(j)
                if p1 != p2:
                    self.p[p1] = p2
                    self.res -= 1
        
        uf = UnionFind(rows * cols + 1)
        dummyNode = rows * cols
        
        directions = [[1, 0], [0, 1]]
        
        def pos(i, j):
            return i * cols + j
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '0':
                    uf.union(pos(i, j), dummyNode)
                if grid[i][j] == '1':
                    for dirc in directions:
                        new_i = i + dirc[0]
                        new_j = j + dirc[1]
                        if new_i < rows and new_j < cols and grid[new_i][new_j] == '1':
                            uf.union(pos(new_i, new_j), pos(i, j))
        return uf.res - 1
                
        
# @lc code=end

