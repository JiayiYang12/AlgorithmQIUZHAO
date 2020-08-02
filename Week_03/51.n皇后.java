import java.util.Set;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    private int n;
    private List<List<String>> res;
    private Set <Integer> cols;
    private Set <Integer> main;
    private Set <Integer> vice;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n <= 0) return res;
        cols = new HashSet<Integer>();
        main = new HashSet<Integer>();
        vice = new HashSet<Integer>();

        helper(0, new LinkedList<Integer> ());
        return res;

    }

    public void helper(int row, LinkedList<Integer> cur) {
        if (row == n) {
            List<String> sub_res = trans(cur);
            res.add(sub_res);
            return ;
        }

        for (int col = 0; col < n; col ++) {
            if (!cols.contains(col) && !main.contains(row + col) && !vice.contains(row - col)) {
                cur.add(col);
                cols.add(col);
                main.add(row + col);
                vice.add(row - col);

                helper(row + 1, cur);

                // reverse
                cur.remove(cur.size() - 1);
                cols.remove(col);
                main.remove(row + col);
                vice.remove(row - col);
            }
        }
        
    }

    public List<String> trans(LinkedList<Integer> cur) {
        List<String> res = new ArrayList<>();
        for (int num: cur) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i ++) {
                sb.append(".");
            }
            sb.replace(num, num + 1, "Q");
            res.add(sb.toString());
        }
        return res;
    }
}
// @lc code=end

