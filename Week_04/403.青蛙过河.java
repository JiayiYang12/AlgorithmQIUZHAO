/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i ++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(0);
        for (int i = 0; i < stones.length; i ++) {
            for (int k: map.get(stones[i])) {
                for (int step = k-1; step <= k + 1; step ++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                    
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}
// @lc code=end

