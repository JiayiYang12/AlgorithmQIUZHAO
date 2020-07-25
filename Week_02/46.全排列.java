import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    int n;
    int []a;
    List<List<Integer>> res = new ArrayList<>();
    int [] visited;
    public List<List<Integer>> permute(int[] a) {
        this.a = a;
        n = a.length;
        visited = new int [n];
        helper(new LinkedList<Integer> ());
        return res;
    }
    public void helper(LinkedList<Integer> cur) {
        if (cur.size() == n) {
            res.add(new LinkedList(cur));
            return;

        }

        for (int i = 0; i < n; i ++) {
            if (visited[i] == 0) {
                cur.add(a[i]);
                visited[i] = 1;
                helper(cur);
                cur.removeLast();
                visited[i] = 0;
            }
        }
    }
}
// @lc code=end

