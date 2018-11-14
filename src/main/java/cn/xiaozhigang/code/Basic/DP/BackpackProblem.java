package cn.xiaozhigang.code.Basic.DP;

public class BackpackProblem {
    /**
     * 问题：0-1背包问题
     * 一个背包有一定的称重W,有N件物品，每件都有自己的价值，记录
     * 在数组V中，也都有自己的重量，记录在数组W中，每件物品只能选择
     * 要装入背包还是不转入背包，要求在不超过背包称重的前提下，选出
     * 物品的总价值最大
     * */

    /**
     * @param value  价值数组
     * @param W      背包承重
     * @param weight 重量数组
     */
    public static int solve(int W, int[] value, int[] weight) {
        if(value == null || weight ==  null || W <= 0)
            return 0;
        int n = value.length;
        if (n != weight.length)
            return -1;
        return solve(n - 1, W, value, weight);
    }

    /**
     * 从下标index开始往前的物品放入最大重量为w的背包中，所能得到的最大值
     * */
    public static int solve(int index,int w,int[] value,int[] weight) {
        if(w - weight[index] < 0) return 0;
        if(index == 0) {
            if(weight[index] > w) {
                return 0;
            }
            else
                return value[index];
        }
        int v1 = solve(index - 1, w, value, weight);
        int v2 = solve(index - 1, w - weight[index], value, weight) + value[index];

        return Math.max(v1,v2);
    }

    public static int solve1(int W,int[] value,int[] weight) {
        if(value == null || weight ==  null || W <= 0)
            return 0;
        if(value.length != weight.length) return -1;
        int n = value.length;

        int[][] dp = new int[n][W+1];
        for(int j = weight[0]; j <= W; j++)
            dp[0][j] = value[0];
        for(int x = 1; x < n; x++) {
            for(int y = 1; y <= W; y++) {
                if(y < weight[x])
                    dp[x][y] = dp[x-1][y];
//                System.out.println("x = " + x + " y = " + y + " weight[x] = " + weight[x] + " value[x] = " + value[x]);
                else
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x - 1][y - weight[x]] + value[x]);
            }
        }

        return dp[n-1][W];
    }

    public static void main(String[] args) {
        int[] value = {24,80,60,30,20};
        int[] weight = {3,4,4,6,7};
        int W = 10;
        System.out.println(solve1(W, value, weight));
    }
}
