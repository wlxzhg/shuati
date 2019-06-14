package cn.xiaozhigang.code.Leetcode.nowcoder.EvaluateReversePolishNotation;

import java.util.LinkedList;

public class Solution {
    public int evalRPN2(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();

        for(String s : tokens) {
            if((s.charAt(0) >= '0' && s.charAt(0) <= '9') ||
                    (s.charAt(0) == '-' && s.length() >= 2 && s.charAt(1) >= '0' && s.charAt(1) <= '9')) {
                stack.add(Integer.valueOf(s));
                continue;
            }

            int first = stack.removeLast();
            int last = stack.removeLast();

            if(s.charAt(0) == '+') {
                stack.add(last + first);
            } else if(s.charAt(0) == '-') {
                stack.add(last - first);
            } else if(s.charAt(0) == '*') {
                stack.add(last * first);
            } else {
                stack.add(last / first);
            }
        }

        return stack.removeLast();
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();

        for(String s : tokens) {
            if(s.charAt(0) == '+') {
                int first = stack.removeLast();
                int last = stack.removeLast();
                stack.add(last + first);
            } else if(s.charAt(0) == '-' && s.length() == 1) {
                int first = stack.removeLast();
                int last = stack.removeLast();
                stack.add(last - first);
            } else if(s.charAt(0) == '*') {
                int first = stack.removeLast();
                int last = stack.removeLast();
                stack.add(last * first);
            } else if(s.charAt(0) == '/'){
                int first = stack.removeLast();
                int last = stack.removeLast();
                stack.add(last / first);
            } else {
                stack.add(Integer.valueOf(s));
            }
        }

        return stack.removeLast();
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(so.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(so.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
