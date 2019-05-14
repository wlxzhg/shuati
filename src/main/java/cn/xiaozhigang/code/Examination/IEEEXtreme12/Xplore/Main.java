package cn.xiaozhigang.code.Examination.IEEEXtreme12.Xplore;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(n);
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        String[] lines = new String[n];
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            lines[i] = sc.nextLine();
        }
        for(int i = 0; i < n; i++) {
            String line = lines[i];
            int index = -1;
            ArrayList<String> names = new ArrayList<String>();

            while ((index = line.indexOf("full_name")) > 0) {
                line = line.substring(index + 10);
                int s = line.indexOf('"');
                s++;
                line = line.substring(s);
                int e = line.indexOf('"');
                String name = line.substring(0,e);
                line = line.substring(e + 1);
                names.add(name);
            }
            index = line.indexOf("citing_paper_count");
            if(index == -1)
                continue;
            line = line.substring(index + "citing_paper_count".length());
            char[] lineArr = line.toCharArray();
            int start = 0;
            for(;start < lineArr.length; start++) {
                if (lineArr[start] >= '0' && lineArr[start] <= '9') {
                    break;
                }
            }

            index = line.indexOf(',');
            int score = Integer.valueOf(line.substring(start,index));
            for (String name : names) {
                if(map.containsKey(name)) {
                    List<Integer> l = map.get(name);
                    l.add(score);
                } else {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(score);
                    map.put(name, l);
                }
            }
        }

        People[] peoples = new People[map.size()];
        int count = 0;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int size = list.size();
            int i = size;
            for(i = size; i >= 1; i--) {
                if(list.get(i-1) >= i) {
                    break;
                }
            }
            peoples[count++] = new People(entry.getKey(),i);
        }

        Arrays.sort(peoples, new Comparator<People>() {
            public int compare(People o1, People o2) {
                if(o2.val == o1.val) {
                    return o1.name.compareTo(o2.name);
                }
                return o2.val - o1.val;
            }
        });

        for(int i = 0;i < peoples.length; i++) {
            System.out.print(peoples[i]);
            if (i != peoples.length - 1) {
                System.out.println();
            }
        }
    }
}

class People {
    String name;
    int val;

    public People(String n, int v) {
        name = n;
        val = v;
    }

    @Override
    public String toString() {
        return  name + ' ' + val;
    }
}
