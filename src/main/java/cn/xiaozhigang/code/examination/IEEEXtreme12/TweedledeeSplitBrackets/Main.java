package cn.xiaozhigang.code.examination.IEEEXtreme12.TweedledeeSplitBrackets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] arr = line.toCharArray();

        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        LinkedList<Integer> queue2 = new LinkedList<Integer>();
        List<Pair> pairs = new ArrayList<Pair>();

        int length = arr.length;
        boolean impossible = false;
        for(int i = 0; i < length; i++) {
            if(arr[i] == '(')
                queue1.add(i);
            else if(arr[i] == '[')
                queue2.add(i);
            else if(arr[i] == ')') {
                if(queue1.isEmpty()) {
                    impossible = true;
                    break;
                }
                int left = queue1.poll();
                pairs.add(new Pair(left,i));
            } else if(arr[i] == ']') {
                if(queue2.isEmpty()) {
                    impossible = true;
                    break;
                }
                int left = queue2.poll();
                pairs.add(new Pair(left,i));
            }
        }
        if (impossible) {
            System.out.print("impossible");
        } else {
            Collections.sort(pairs, new Comparator<Pair>() {
                public int compare(Pair o1, Pair o2) {
                    return o1.start - o2.start;
                }
            });

            int size = pairs.size();
            if(size % 2 == 1) {
                System.out.print("impossible");
            } else {
                int[] answer = new int[length];
                Arrays.fill(answer, 2);
                for(int i = 0; i < size / 2; i++) {
                    answer[pairs.get(i).start] = 1;
                    answer[pairs.get(i).end] = 1;
                }
                for (int i = 0; i<length; i++) {
                    System.out.print(answer[i]);
                    if (i != length - 1) {
                        System.out.print(" ");
                    }
                }
            }

        }
    }
}

class Pair {
    int start;
    int end;

    public Pair(int s, int e) {
        start = s;
        end = e;
    }
}
