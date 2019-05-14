package cn.xiaozhigang.code.Examination.IEEEXtreme12.MakeDistinct;

import java.util.*;

class HelpNumber {
    Integer val;
    int addCount;
    int disCount;
    int count;

    public HelpNumber(int v,int a,int d) {
        val = v;
        addCount = a;
        disCount = d;
    }

    @Override
    public int hashCode() {
        return val.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return val == ((HelpNumber)obj).val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        LinkedList<Integer> list1 = new LinkedList<Integer>();

        for(int i = 0; i < t; i++) {
            int num = sc.nextInt();
            list1.add(num);
        }

        HashSet<Integer> set1 = new HashSet<Integer>();
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            Integer a = iterator.next();
            if(set1.contains(a))
                continue;
            set1.add(a);
            iterator.remove();
        }

        HashMap<HelpNumber,Integer> set2 = new HashMap<HelpNumber,Integer>();

        iterator = list1.iterator();
        while (iterator.hasNext()) {
            Integer a = iterator.next();
            HelpNumber h = new HelpNumber(a, 0, 0);
            if (set2.containsKey(h)){
//                HelpNumber m = set2
            }
        }

        iterator = list1.iterator();
        int num = -1;
        while (iterator.hasNext()) {
            Integer a = iterator.next();

        }
    }
}
