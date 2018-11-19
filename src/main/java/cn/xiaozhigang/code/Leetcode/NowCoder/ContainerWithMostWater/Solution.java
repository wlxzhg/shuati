package cn.xiaozhigang.code.Leetcode.NowCoder.ContainerWithMostWater;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目：盛最多水的容器。给定n个非负整数a1,a2,a3...an，每个数
 * 代表坐标中的一个点(i,ai),在坐标内画n条垂直线，垂直线i的两个
 * 端点分别为(i,ai)和(i,0)，找出其中的两条线，使得它们与x轴共同
 * 构成的容器可以容纳最多的水。
 * */
public class Solution {

    /**
     * 思路一：暴力求解，n个坐标两两枚举，求出最多的值
     * 时间：O(n^n)，空间：O(1)
     * */
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int water = (j - i) * Math.min(height[i],height[j]);
                if(water > ans)
                    ans = water;
            }
        }
        return ans;
    }

    /**
     * 思路2：从减少不必要枚举的点出发。
     * 如果一个点高度比它前一个点较小，则它永远不适合作为左边的线，因为
     * 不管与其后的哪个点组合，都会比其前一个点组与之后的那个点组合结果小。
     * 同理，如果一个点比其后一个点小，那么它也不适合作为右边的点
     * 空间：O(n)   时间：实测并没有提示
     * */
    public int maxArea2(int[] height) {
        int ans = Integer.MIN_VALUE;

        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> suf = new ArrayList<Integer>();

        pre.add(0);
        suf.add(height.length - 1);

        for(int i = 1; i < height.length - 1; i++) {
            if(height[i] > height[i - 1])
                pre.add(i);
            if(height[i] > height[i + 1])
                suf.add(i);
        }

        for(int i : pre) {
            for(int j : suf) {
                int water = (j - i) * Math.min(height[i],height[j]);
                if(water > ans)
                    ans = water;
            }
        }

        return ans;
    }

    /**
     * 思路3：优化思路2，对于一条线，其后所有比它矮的线
     * 都可以排除出左边代遍历集合。其前所有比它矮的线都可
     * 以排除出右边代遍历集合。
     * 空间复杂度：O(n)，时间复杂度：实测有了较大改善
     * 与网站最好结果相差不大
     * */
    public int maxArea3(int[] height) {
        int ans = Integer.MIN_VALUE;

        List<Integer> pre = new LinkedList<Integer>();
        List<Integer> suf = new LinkedList<Integer>();

        pre.add(0);
        int max = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] > height[max]) {
                pre.add(i);
                max = i;
            }
        }

        max = height.length - 1;
        suf.add(height.length - 1);
        for(int i = height.length - 2; i >= 0; i--) {
            if(height[i] > height[max]) {
                suf.add(i);
                max = i;
            }
        }

        System.out.println("pre : " + Arrays.toString(pre.toArray()));
        System.out.println("suf : " + Arrays.toString(suf.toArray()));


        for(int i : pre) {
            for(int j : suf) {
                if(j <= i)
                    break;
                int water = (j - i) * Math.min(height[i],height[j]);
                if(water > ans)
                    ans = water;
            }
        }

        return ans;
    }

    /**
     * 思路4：看了网友解答。贪心算法？起始左边固定为第一条边，右边固定为
     * 最后一条边。每次去掉较短的边。
     * 证明：最优解不会被错过。
     * 假设最优解为x,y；指针i,j从两侧逼近x,y。由于每次i++或j--那么一定存在
     * 一个时刻x=i或y=j。
     * 1.x=i，j>y时，此时一定有height[j]<height[i]，否则x,y就不是最优解了，
     * 那么j将逐渐逼近y,直到j=y。
     * 2.j=y,x<i时，同理一定有height[i]<height[j]，i将逐渐逼近x，不会错过。
     * 注：不会有x=i时，j<y的情况，这是是j先到达j的情况，一定会经过情况2
     * */
    public int maxArea4(int[] height) {
        int left = 0,right = height.length - 1;
        int ans = Integer.MIN_VALUE;

        while (left < right) {
            int tmp = (right - left) * Math.min(height[left],height[right]);
            if(tmp > ans) ans = tmp;
            if(height[left] > height[right])
                right--;
            else
                left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.maxArea4(new int[] {1,8,6,2,5,10,4,8,3,7,6}));
        System.out.println(so.maxArea3(new int[] {1,8,6,2,5,10,4,8,3,7,6}));
    }
}
