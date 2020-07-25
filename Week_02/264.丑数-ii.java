import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    private int [] factor = {2, 3, 5};
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        int cnt = 0;
        while (!heap.isEmpty()) {
            long cur = heap.poll();
            if (++cnt >= n) {
                return (int)cur;
            }
            for (int f: factor) {
                if (! heap.contains(cur * f)) {
                    heap.add(cur * f);
                }
            }
        }
        return -1;
    }
}
// @lc code=end

