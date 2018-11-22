package cn.xiaozhigang.code.Leetcode.NowCoder.BestTimeToBuyAndSellStock;

public class Solution {
    /**
     * 题目：一个数组表示股票每天的价格。只可以买卖一次，求最大收益
     * 思路：f(i)表示i天卖出的最大值，则f(i) = prices[i] - prices[min]
     *       （min < i且对于任意j<i,j!=min有prices[min]<prices[j]）
     * */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int answer = 0;
        int min = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - min > answer)
                answer = prices[i] - min;

            if(prices[i] < min)
                min = prices[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.maxProfit(new int[] {9,3,10,8,9,4,2}));
    }
}
