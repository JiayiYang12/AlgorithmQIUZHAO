import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    int [] nums;
    int n;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        n = nums.length;
        helper(new ArrayList<Integer>(), 0);
        return res;
    }

    public void helper(ArrayList<Integer> cur, int ind) {
        // terminator
        if (ind == n) {
            res.add(new ArrayList(cur));
            return ;
        }
        // process current logic
        // not choose current element as part of cur:
        helper(cur, ind + 1);
        // choose current element as part of cur:
        cur.add(nums[ind]);
        helper(cur, ind + 1);

        // reverse state
        cur.remove(cur.size() - 1);
        

    }
}
// @lc code=end

