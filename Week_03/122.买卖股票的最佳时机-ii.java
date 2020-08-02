/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i =0; i < prices.length - 1; i ++) {
            int s = prices[i+1] - prices[i];
            if (s > 0) {
                res += s;
            }
        }
        return res;
    }
}
// @lc code=end

