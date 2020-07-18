/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for (int start = 0; count < n; start ++) {
            int cur = start;
            int prev = nums[cur];
            do {
                int next = (cur + k) % n;
                int val = nums[next];
                nums[next] = prev;
                prev = val;
                cur = next;
                count ++;
            } while (start != cur);


        }
    }
}
// @lc code=end

