/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    Map <LinkedList<Integer>, Integer> map = new HashMap <>();
    int n;
    List<List<Integer>> res = new ArrayList<> ();
    int [] visited;
    int [] a;
    public List<List<Integer>> permuteUnique(int[] a) {
        this.a = a;
        n = a.length;
        visited = new int [n];
        helper(new LinkedList<Integer> ());
        return res;
    }
    public void helper (LinkedList<Integer> cur) {
        if (cur.size() == n) {
            if (map.getOrDefault(cur, 0) == 0) {
                res.add(new LinkedList(cur));
                map.put(cur, 1);
            }
            return ;
        }
        for (int i = 0; i < n; i ++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                cur.add(a[i]);
                helper(cur);
                visited[i] = 0;
                cur.removeLast();
            }
        }

    }
}
// @lc code=end

