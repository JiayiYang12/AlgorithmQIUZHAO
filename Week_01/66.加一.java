/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] a) {
        for (int i = a.length - 1; i > -1; i --) {
            a[i] ++;
            a[i] %= 10;
            if (a[i] != 0) return a;
        }
        a = new int [a.length + 1];
        a[0] = 1;
        return a;
    }
}
// @lc code=end

