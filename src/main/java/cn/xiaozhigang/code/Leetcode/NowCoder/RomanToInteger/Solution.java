package cn.xiaozhigang.code.Leetcode.NowCoder.RomanToInteger;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    /**
     * 题目：罗马数字转换为整数。
     * 思路：注意两个字符的情况即可。
     *       romanToInt1比romanToInt2更高效
     * */
    public int romanToInt2(String s) {
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);

        int i = 0;
        int answer = 0;
        for(; i < arr.length - 1; i++) {
            if(map.get(arr[i+1]) > map.get(arr[i])) {
                answer += map.get(arr[i+1]) - map.get(arr[i]);
                i++;
            } else {
                answer += map.get(arr[i]);
            }
        }
        if(i < arr.length)
            answer += map.get(arr[i]);

        return answer;
    }

    public int romanToInt(String s) {
        char[] arr = s.toCharArray();

        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case 'M': answer += 1000; break;
                case 'D': answer += 500;  break;
                case 'C':
                    if(i < arr.length - 1) {
                        if(arr[i+1] == 'D') {
                            answer += 400;
                            i++;
                        } else if(arr[i+1] == 'M') {
                            answer += 900;
                            i++;
                        } else {
                            answer += 100;
                        }
                    } else {
                        answer += 100;
                    }
                    break;
                case 'L': answer += 50; break;
                case 'X':
                    if(i < arr.length - 1) {
                        if(arr[i+1] == 'L') {
                            answer += 40;
                            i++;
                        } else if(arr[i+1] == 'C') {
                            answer += 90;
                            i++;
                        } else {
                            answer += 10;
                        }
                    } else {
                        answer += 10;
                    }
                    break;
                case 'V':
                    answer += 5;break;
                case 'I':
                    if(i < arr.length - 1) {
                        if(arr[i+1] == 'V') {
                            answer += 4;
                            i++;
                        } else if(arr[i+1] == 'X') {
                            answer += 9;
                            i++;
                        } else {
                            answer += 1;
                        }
                    } else {
                        answer += 1;
                    }
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.romanToInt("III"));
        System.out.println(so.romanToInt("IV"));
        System.out.println(so.romanToInt("IX"));
        System.out.println(so.romanToInt("LVIII"));
        System.out.println(so.romanToInt("MCMXCIV"));
        System.out.println(so.romanToInt("CM"));

        System.out.println(" ----------------------- ");
        System.out.println(so.romanToInt2("III"));
        System.out.println(so.romanToInt2("IV"));
        System.out.println(so.romanToInt2("IX"));
        System.out.println(so.romanToInt2("LVIII"));
        System.out.println(so.romanToInt2("MCMXCIV"));
        System.out.println(so.romanToInt2("CM"));

    }
}
