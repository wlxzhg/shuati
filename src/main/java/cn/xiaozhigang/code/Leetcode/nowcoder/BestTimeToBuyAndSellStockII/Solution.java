package cn.xiaozhigang.code.Leetcode.nowcoder.BestTimeToBuyAndSellStockII;

/**
 * 题目：一个数组里存储股票每天的价格，求利润最大值。
 *      可以进行任意次交易，但购买新股票前必须将手里
 *      的股票出售
 * 思路：每次可以赚钱就卖出。
 *      从头找递减序列，递减序列（可能只有一个元素）
 *      的结尾就是要买入的股票，卖出的时机是下一天
 *      （注意下一天越界）
 * */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int profit = 0,index = 0,length = prices.length;
        while (index < length - 1) { //index表示被买入的股票，显然最后一天的股票不能买入
            if(prices[index + 1] <= prices[index]) {
                index++;
                continue;
            }
            //递减序列的末尾卖出
            profit += prices[index + 1] - prices[index];
            //继续判断是否是递减序列
            index++;
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(so.maxProfit(new int[]{3,6,2,7,3}));
        System.out.println(so.maxProfit(new int[]{3,2}));

    }
}
