import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        helper(1, new LinkedList<Integer>());
        return res;
    }
    public void helper(int start, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            res.add(new LinkedList(cur));
            return ;
        }
        for (int i = start; i <= n; i ++) {
            cur.add(i);
            helper(i + 1, cur);
            cur.removeLast();
        }
    }
}
// @lc code=end

