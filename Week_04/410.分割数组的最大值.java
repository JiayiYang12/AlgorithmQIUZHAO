/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // 
        int[] sub = new int[n+1];
        for (int i = 0; i < n; i ++){
            sub[i+1] = sub[i] + nums[i];
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= Math.min(i, m); j ++) {
                for (int k = 0; k < i; k ++) {
                    // 问空数组是否有效，无意义
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];

    }
}
// @lc code=end

