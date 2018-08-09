package cn.xiaozhigang.code.sword.VerifySquenceOfBST;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        boolean res = so.VerifySquenceOfBST(new int[] {2,9,5,16,17,15,19,18,12});
        System.out.println(res);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        return dfs(0,sequence.length - 1,sequence);
    }

    private boolean dfs(int i,int j,int[] sequence) {
        System.out.println("i = " + i + "  j = " + j);
        if(j - i <= 1) return true;
        int s;
        for(s = i; s < j && sequence[s] < sequence[j]; s++);
        int e = s;
        for(;e < j && sequence[e] > sequence[j]; e++);

        if(e < j) return false;

        return dfs(i,s-1,sequence) && dfs(s,j-1,sequence);
    }
}
