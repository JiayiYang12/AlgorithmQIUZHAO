#
# @lc app=leetcode.cn id=36 lang=python3
#
# [36] 有效的数独
#

# @lc code=start
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [[0] * 9 for _ in range(9)]
        cols = [[0] * 9 for _ in range(9)]
        boxes = [[0] * 9 for _ in range(9)]
        
        print(len(rows), len(rows[0]))
        
        for i in range(9):
            for j in range(9):
                if board[i][j] is not '.':
                    num = int(board[i][j]) - 1
                    box_ind = i // 3 * 3 + j // 3
                    
                    rows[i][num] += 1
                    cols[j][num] += 1
                    boxes[box_ind][num] += 1
                    
                    if rows[i][num] > 1 or cols[j][num] > 1 or boxes[box_ind][num] > 1:
                        return False
        
        return True
# @lc code=end

