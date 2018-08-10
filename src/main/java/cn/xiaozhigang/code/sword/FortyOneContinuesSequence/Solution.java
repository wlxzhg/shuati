package cn.xiaozhigang.code.sword.FortyOneContinuesSequence;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
//        Solution so = new Solution();
//        ArrayList<ArrayList<Integer>> ans = so.FindContinuousSequence(30);
//        for(ArrayList<Integer> i : ans) {
//            System.out.println(i.toString());
//        }

        (new Solution()).testFindNumbersWithSum();
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        int small = 1,big = 2;
        int end = sum / 2 + 1;
        int nowSum = small + big;
        while (small <= end) {
            if(nowSum == sum) {
                ArrayList<Integer> one = new ArrayList<Integer>();
                for(int i = small; i <= big; i++)
                    one.add(i);
                ans.add(one);
                nowSum -= small;
                small++;
            } else if(nowSum < sum) {
                big++;
                nowSum += big;
            } else {
                nowSum -= small;
                small++;
            }
        }
        return ans;
    }

    public void testFindNumbersWithSum() {
        ArrayList<Integer> ans = FindNumbersWithSum(null,6);
        System.out.println(ans.toString());
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(array == null || array.length == 1 || array.length == 0) return ans;

        int small = 0,big = array.length - 1;
        int nowSum = array[small] + array[big];
        while (small < big) {
            if(nowSum == sum)  {
                ans.add(array[small]);
                ans.add(array[big]);
                break;
            } else if(nowSum > sum){
                big--;
            } else {
                small++;
            }
            nowSum = array[small] + array[big];
        }

        return ans;
    }
}
