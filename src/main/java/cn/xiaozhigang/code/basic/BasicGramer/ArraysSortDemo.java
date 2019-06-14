package cn.xiaozhigang.code.basic.BasicGramer;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortDemo {
    public static void main(String[] args) {
        int [] arr = {4,3,2,8,1};
        Arrays.sort(arr);

        float [] floatArr = {1.2f,4.5f,8.0f,9.1f};
        Arrays.sort(floatArr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(floatArr));

        Integer[] integerArr = {1, 2, 3, 4, 5};
        Arrays.sort(integerArr,new Comparator<Integer>() {
            public int compare(Integer o1,Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(integerArr));
    }
}
