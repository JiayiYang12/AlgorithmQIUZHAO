#
# @lc app=leetcode.cn id=212 lang=python3
#
# [212] 单词搜索 II
#

# @lc code=start
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
END_WORD = '#'

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if words is None or board is None or board[0] is None:
            return []

        self.res = set()

        # 建立字典树
        root = {}
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, {})
            node[END_WORD] = END_WORD
        
        # dfs
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in root:
                    self.dfs(board, i, j, root, '')
        
        return list(self.res)
    
    def dfs(self, board, row, col, cur_node, cur_word):
        cur_word += board[row][col]
        cur_node = cur_node[board[row][col]]

        if END_WORD in cur_node:
            self.res.add(cur_word)
        
        tmp, board[row][col] = board[row][col], '@'
        for i in range(4):
            newrow = row + dy[i]
            newcol = col + dx[i]

            # 判定边界条件
            if 0<=newcol<len(board[0]) and 0<=newrow<len(board) and board[newrow][newcol] != '@' and board[newrow][newcol] in cur_node:
                self.dfs(board, newrow, newcol, cur_node, cur_word)


        board[row][col] = tmp
    
    
# @lc code=end

