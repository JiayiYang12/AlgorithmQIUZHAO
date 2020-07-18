/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (j != 0 && nums[j - 1] == nums[j]) {
                j ++;
                continue;
            }
            nums[i++] = nums[j++];
        }
        return i;
    }
}
// @lc code=end

