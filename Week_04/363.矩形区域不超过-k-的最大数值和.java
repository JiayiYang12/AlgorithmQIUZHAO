/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int res = Integer.MIN_VALUE;
        if (matrix == null || rows == 0 || cols == 0) {
            return res;
        }
        for (int lt = 0; lt < cols; lt ++) {
            int[] rowSum = new int[rows];
            for (int rt = lt; rt < cols; rt ++) {
                for (int row = 0; row < rows; row ++) {
                    rowSum[row] += matrix[row][rt];
                }
                res = Math.max(res, helper(rowSum, k));
                if (res == k) return k;
            }
        }
        return res;
    }

    public int helper(int[] rowSum, int k) {
        int n = rowSum.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            int sum = 0;
            for (int j = i; j < n; j ++) {
                sum += rowSum[j];
                res = sum <= k? Math.max(res, sum): res;
            }
        }
        return res;
    }
}

// @lc code=end

