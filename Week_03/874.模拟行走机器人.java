import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    int [] dirX = new int [] {0, 1, 0, -1};
    int [] dirY = new int [] {1, 0, -1, 0};

    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int di = 0;
        int curX = 0, curY = 0;
        // Set<int []> obs = new HashSet<>();
        // for (int [] arr: obstacles) {
        //     System.out.println(arr[0] + "," + arr[1]);
        //     obs.add(new int [] {arr[0], arr[1]});
        // }
        // Iterator<int []> it = obs.iterator();
        // System.out.println(it.next());

        Set<String> obs = new HashSet<String>();
        for (int i=0;i<obstacles.length;i++) {
            obs.add(obstacles[i][0]+","+obstacles[i][1]);
        }

        for (int cmd: commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            }
            else if (cmd == -1) {
                di = (di + 1) % 4;
            }
            else if (cmd > 0) {
                for (int i = 0; i < cmd; i ++) {
                    int nX = curX + dirX[di];
                    int nY = curY + dirY[di];
                    int [] tmp = new int [] {nX, nY};
                    System.out.println(tmp[0] + "," + tmp[1]);
                    if (! obs.contains(nX+","+nY)) {
                    // if (! obs.contains(tmp)) {

                        curX = nX;
                        curY = nY;
                        res = Math.max(res, curX * curX + curY *
                        curY);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

