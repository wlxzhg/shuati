package cn.xiaozhigang.code.sword.FortyFindNumbersAppearOnce;

/**
 * ��������������ֻ����һ�ε����֣��������ֶ�����2��
 * ˼·�����ֻ��һ�����飬��������������ּ�Ϊ����
 * ������ֳ���������ֻ��һ������һ�ε����֣��������ֳ����������ɡ�
 *
 * */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        so.FindNumsAppearOnce(new int[] {1,6,2,4,3,3,5,2,1,4},num1,num2);
        so.FindNumsAppearOnce(new int[] {1,1,2,3},num1,num2);
        System.out.println(num1[0] + "\t" + num2[0]);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = 0;
        for(int i : array) result ^= i;

        int shift = 1;
        while ((shift & result) == 0)
            shift <<= 1;

        int i = 0,j = array.length - 1;
        while (i < j) {
            while (i < j && (shift & array[i]) == 0) i++;
            while (i < j && (shift & array[j]) != 0) j--;
            swap(array,i,j);
        }
        if((shift & array[i]) != 0) i--;

        num1[0] = 0;
        num2[0] = 0;
        for(int k = 0; k <= i; k++)
            num1[0] ^= array[k];
        for(int k = i + 1; k <= array.length - 1; k++)
            num2[0] ^= array[k];
    }

    private void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
