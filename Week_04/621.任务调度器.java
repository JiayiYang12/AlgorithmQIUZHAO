/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start


class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks) {
            map[c - 'A'] ++;
        }
        // map[25]为出现次数最多的字目的出现次数
        Arrays.sort(map);
        int res = 0;
        // map[i] = 
        while (map[25] > 0) {
            int i = 0; // 每进行一轮，走过的时间数
            while (i <= n) { // 以轮数为单位考虑
                if (map[25] == 0) { // 若最大数都为0，则全体任务剩余数都为0，程序结束
                    break;
                }
                if (i < 26 && map[25 - i] > 0) { // 如果任务种类数大于n,则减少相应的任务
                    map[25 - i] --;
                }
                // 若任务种类数小于n，则存在待命时间（无需编程体现）
                // 没执行完一个任务，总时间需加一，当前轮中完成的任务数也要+1
                res ++;
                i ++;
            }
            Arrays.sort(map);

        }
        return res;
        
    }
}
// @lc code=end

