package cn.xiaozhigang.code.Basic.BasicGramer.CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++)
            list.add(i);

        Integer[] arr = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(arr));

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 10; i < 15; i++) set.add(i);
        list.addAll(set);
        System.out.println(list);

        set.addAll(list);
        System.out.println(set);
    }
}
