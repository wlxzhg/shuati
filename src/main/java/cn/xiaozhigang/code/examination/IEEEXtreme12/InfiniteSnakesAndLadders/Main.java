package cn.xiaozhigang.code.examination.IEEEXtreme12.InfiniteSnakesAndLadders;

public class Main {
    public static void main(String[] args) {
        System.out.println(position(1, 4, 4));
        System.out.println(position(2, 4, 4));
        System.out.println(position(3, 4, 4));
        System.out.println(position(4, 4, 4));
        System.out.println(position(1, 3, 4));
        System.out.println(position(3, 1, 4));
    }

    public static int position(int x,int y,int n) {
        int answer = (y - 1) * 4;
        if((y & 1) == 1) {
            answer += x;
        } else {
            answer += (n - x + 1);
        }
        return answer;
    }
}
