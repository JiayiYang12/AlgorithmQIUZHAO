/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill: bills) {
            if (bill == 5) {
                five ++;
            }
            else if (bill == 10) {
                ten ++;
                if (--five < 0) {
                    return false;
                }
            }
            else {
                twenty ++;
                if (ten > 0 && five > 0) {
                    ten --;
                    five --;
                    continue;
                }
                else if (five >= 3) {
                    five -= 3;
                    continue;
                }
                else {
                    return false;
                }
                
            }
        }
        return true;
    }
}
// @lc code=end

