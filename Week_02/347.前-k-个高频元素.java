import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry <Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry <Integer, Integer> entry: map.entrySet()) {
            heap.add(entry);
        }
        int []res = new int [k];
        int ind = 0;
        while (ind < k) {
            Map.Entry<Integer, Integer> elem = heap.poll();
            res[ind++] = elem.getKey();
        }
        return res;
    }
}
// @lc code=end

