package cn.xiaozhigang.code.sword.FortyTwoReverseSetence;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        so.testReverseSentence();
    }

    public void testReverseSentence() {
        System.out.println(ReverseSentence("hello world"));
        System.out.println(ReverseSentence("hello"));
        System.out.println(ReverseSentence("    1"));
        System.out.println(ReverseSentence("    "));
        System.out.println(ReverseSentence("    hello h loo. "));
        System.out.println(ReverseSentence("    hello h loo."));
        System.out.println(ReverseSentence("hello h loo. "));
    }

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0 || str.length() == 1) return str;

        char[] array = str.toCharArray();
        revert(array, 0, array.length - 1);
        int start = 0,end = 0;
        while (end < array.length && start < array.length) {
//            System.out.println("start:" + start + "\tend:" + end);
            while (start < array.length && array[start] == ' ')
                start++;
            end = start;
            while (end < array.length && array[end] != ' ')
                end++;
            end--;
            revert(array,start,end);

            start = end + 1;
        }
        return new String(array);
    }

    private void revert(char[] array,int i,int j) {
        if(i >= j) return;

        while (i < j) {
            swap(array,i,j);
            i++;
            j--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
