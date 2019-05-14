package cn.xiaozhigang.code.Examination.IEEEXtreme12.BearSums;

import java.util.*;

/**
 * 给定一个目标数和一个数组，求数组中是否有两个数的和等于该目标数
 * 如果有多个则按照数组顺序输出较靠前的一对（4 5 3 4中5 3比4 4靠前）
 * 算法：
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 算法思想：构造hashSet用于保存数据；
 *          遍历数组，如果当前元素在set中则说明找到了一对满足条件的数据，结束循环；
 *          否则求：目标值减去当前元素，放入set
 * AC
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        Set<Integer> set = new HashSet<Integer>();
        for(int t = 0; t < times; t++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int[] arr = new int[e];

            set.clear();

            boolean flag = false;
            for(int i = 0; i < e; i++) {
                arr[i] = sc.nextInt();

            }

            for(int i = 0; i < e; i++) {
                int tar = s - arr[i];
                if (set.contains(arr[i])) {
                    flag = true;
                    if(tar < arr[i]) {
                        System.out.print(tar + " " + arr[i]);
                    } else {
                        System.out.print(arr[i] + " " + tar);
                    }
                    break;
                } else {
                    set.add(tar);
                }
            }
            if(!flag) {
                System.out.print("!OK");
            }

            if(t != times - 1) {
                System.out.println();
            }
        }
    }
}
