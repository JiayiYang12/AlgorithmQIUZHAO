#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#

# @lc code=start
class Solution:
    def __init__(self):
        self.p = []
        self.res = 0
        
    def union(self, i, j):
        p1 = self.find(i)
        p2 = self.find(j)
        if p1 != p2:
            self.p[p1] = p2 
            self.res -= 1
    
    def find(self, i):
        root = i
        while self.p[root] != root:
            root = self.p[root]
        while self.p[i] != i:
            x = i; i = self.p[x]; self.p[x] = root;
        return root
         
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        self.p = [i for i in range(n)]
        self.res = n
        for i in range(n):
            for j in range(i+1, n):
                if M[i][j] == 1:
                    self.union(i, j)
        return self.res
        
# @lc code=end

