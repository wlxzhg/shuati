package cn.xiaozhigang.code.MinStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private LinkedList<Integer> data = new LinkedList<Integer>();
    private LinkedList<Integer> min = new LinkedList<Integer>();

    public void push(int node) {
        data.add(node);

    }

    public void pop() {

    }

    public int top() {
return 0;

    }

    public int min() {
        return 0;
    }
}
