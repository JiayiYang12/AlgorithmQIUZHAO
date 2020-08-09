### 几道解法相似的动规题，放在一起总结
#### 问题描述
- 所解决的问题：给定数组（一维或多维），进行某种操作变换，求某个值
- 使用的方法：建立二维的dp table，并且在自底向上给数组元素赋值的过程中，均从dp table的最后一行的最后一个元素开始，行指针由n-1到0，列指针由i+1到n-1(边界条件可能有所出入的，视具体问题而定)
- 可以使用这种方法的原因：dp table中的base case（或某些特殊情形）是确定的；存在嵌套的关系（换句话说，某特定区间的取值和其子区间密切相关）
### 题目和题解
#### 647. 回文子串
- 题目要求：找出给定字符串中的回文串个数
- 题解：
```java
public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i ++) dp[i][i] = true;
        int res= n;
        for (int i = n-1; i >= 0; i --) {
            for (int j = i+1; j < n; j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1)  {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) res ++;
            }
        }
        return res;
    }
```
- 反思
1. base case（两个相邻相等元素 / 单一元素 都是回文子串）清晰；存在嵌套关系（若外层元素相等，又内层字符串是回文子串，则其本身一定是）
2. 是否可从前往后动规？不可。从前往后递归有两种走法，一种是走上三角形：但考虑dp[i][j]表示s[i .. j]是否为回文串，上三角形中j>i，dp table失去意义；另一种是走下三角形：但在更新元素过程中，大量的值需被调用却还未被赋值，故无法计算。综上只能选择从前往后动规。
#### 312. 戳气球
- 题目要求：给定一个数组，可以从中任意选择元素删去，每次删去元素时计算其本身、其左和其右三个元素的乘积；元素删去后其左右两个元素即相邻；求当全部元素删除后所能获得的乘积的最大值。
- 题解：
```java
public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] a = new int[n+2];
        for (int i = 0; i < n+2; i++){
            if (i == 0 || i == n+1) {
                a[i] = 1;
            }
            else {
                a[i] = nums[i-1];
            }
        }
        for (int i = n - 1; i >= 0; i --) {
            for (int j = i + 2; j < n+2; j ++) {
                for (int k = i+1; k < j; k ++) {
                    dp[i][j] = Math.max(dp[i][j], a[i] * a[k] * a[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n+1];
    }
```
- 反思：
关键在于找到子问题：k遍历(i, j)内所有值, [i .. j]区间内符合题意的结果，应为以各种可能k值划分[i, j]，得到一系列[i, k]和[k. j]子区间，计算两个子区间内符合题意的结果以及当前三个划分点乘积，取最大值作为dp[i][j]。每一次划分问题或深入思考时，只需要停留在当前层，对于[i, k]或[k. j]层次的结果，应当保留抽象的印象在那。
