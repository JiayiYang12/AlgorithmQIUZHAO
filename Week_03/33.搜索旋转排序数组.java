/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lt = 0, rt = nums.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[lt] <= nums[mid]) {
                // 左半区间有序
                if (target >= nums[lt] && target < nums[mid]) {
                    rt = mid - 1;
                }
                else {
                    lt = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[rt]) {
                    lt = mid + 1;
                }
                else {
                    rt = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

