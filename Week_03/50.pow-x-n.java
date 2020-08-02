/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0? helper(x, N): 1 / helper(x, -N);
    }

    public double helper(double x, long n) {
        if (n == 0) return 1;
        double t = helper(x, n / 2);
        return n % 2 == 1? x * t * t: t * t;
    }
}
// @lc code=end

