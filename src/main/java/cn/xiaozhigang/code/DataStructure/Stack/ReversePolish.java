package cn.xiaozhigang.code.DataStructure.Stack;

import java.util.LinkedList;

public class ReversePolish {
    public static void main(String[] args) {
        ReversePolish rp = new ReversePolish();
        String suffix = rp.toReversePolish("9+(3+1)*3+10+(2/1)");
        rp.getResult(suffix);
    }

    public int getResult(String suffix) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        char[] arr = suffix.toCharArray();
        int index = 0;
        int length = arr.length;
        while (index < length) {
            if (arr[index] >= '0' && arr[index] <= '9') {
                int start = index, end = index;
                while (arr[end] != '#') end++;
                stack.add(Integer.valueOf(suffix.substring(start, end)));
                index = end + 1;
            } else {
                int first = stack.removeLast();
                int second = stack.removeLast();
                int res = 0;
                if(arr[index] == '+') {
                    res = first + second;
                } else if(arr[index] == '-') {
                    res = second - first;
                } else if (arr[index] == '*') {
                    res = second * first;
                } else {
                    res = second / first;
                }
                stack.add(res);
                index++;
            }
        }
        System.out.println(stack.getLast());
        return 0;
    }

    //flag == true 为push；flag == false为pop
    /**
     * 优先级
     * */
    public int getPriority(char ch,boolean flag) {
        int ret = -1;
        switch (ch) {
            case '+':
            case '-':
                ret = 1;
                break;
            case '*':
            case '/':
                ret = 2;
                break;
            case '(':
                ret = (flag) ? 3 : 0;
                break;
        }
        return ret;
    }

    /**
     * 获取后缀表达式
     * @param 没有空格
     * @return 数字以#结束
     * */
    public String toReversePolish(String fourStr) {
        char[] arr = fourStr.toCharArray();
        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = arr.length;
        for( ;i < length;i++) {
            if(arr[i] >= '0' && arr[i] <= '9'){
                while (i < length && arr[i]>='0'&&arr[i]<='9')
                    sb.append(arr[i++]);
                sb.append('#');
                i--;
            } else if(arr[i] == ')') {
                while (!stack.isEmpty() && stack.getLast() != '(') {
                    sb.append(stack.removeLast());
                }
                stack.removeLast();
            } else if(stack.isEmpty() || getPriority(stack.getLast(),false) < getPriority(arr[i],true))
                stack.add(arr[i]);
            else {
                while (!stack.isEmpty() && getPriority(stack.getLast(), false) >= getPriority(arr[i], true)) {
                    sb.append(stack.removeLast());
                }
                stack.add(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
