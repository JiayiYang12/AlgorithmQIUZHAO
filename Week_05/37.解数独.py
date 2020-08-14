#
# @lc app=leetcode.cn id=37 lang=python3
#
# [37] 解数独
#

# @lc code=start
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = [set(range(1, 10)) for _ in range(9)]        
        cols = [set(range(1, 10)) for _ in range(9)]
        boxes = [set(range(1, 10)) for _ in range(9)]
        empty = []
        
        # 制作各行、列、box未出现过的元素的集合
        for i in range(9):
            for j in range(9):
                b_ind = i // 3 * 3 + j // 3
                if board[i][j] is not '.':
                    val = int(board[i][j])
                    rows[i].remove(val)
                    cols[j].remove(val)
                    boxes[b_ind].remove(val)
                else:
                    empty.append((i, j))
        
        def dfs(iter = 0):
            if iter == len(empty):
                return True
            i, j = empty[iter]
            b_ind = i // 3 * 3 + j // 3
            for num in rows[i] & cols[j] & boxes[b_ind]:
                board[i][j] = str(num)
                rows[i].remove(num)
                cols[j].remove(num)
                boxes[b_ind].remove(num)
                
                # drill down
                if dfs(iter+1):
                    return True
                
                # reverse state
                rows[i].add(num)
                cols[j].add(num)
                boxes[b_ind].add(num)
        
        dfs()
        
# @lc code=end

