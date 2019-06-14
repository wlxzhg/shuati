package cn.xiaozhigang.code.examination.IEEEXtreme12.XtremeFakeCoins;

import java.util.*;

/**
 * 假硬币问题
 * 有若干个硬币，其中有两个是假的。现在有一个天平可以承重。
 * 现在一直进行了n次测量，每次称重选取的硬币也确定好了。
 * 求这样的A,B,C,D（四个硬币），当AB是假硬币时和当CD时假硬币时
 * 四次测量的结果一样。
 * 思路：因为一共最多有26枚硬币，求出所有硬币组合26 * 25 / 2为
 * 假币的测量结果复杂度也不高。然后找出结果相同的即可，找结果相同的
 * 可以使用hashSet将将结果组合成字符串放进set判断。
 * 此题算法不复杂，难点在于数据结构合理设计和巧妙利用HashSet等集合结构
 * AC
 * */

//表示测量的集合
class WeightingsHolder {
    ArrayList<Weightings> holders = new ArrayList<Weightings>();

    //将一次测量加入
    public void addWeightings(String str) {
        Weightings w = new Weightings();
        int i = str.indexOf("-");
        int l = str.length();
        w.first = str.substring(0,i).toCharArray();
        w.second = str.substring(i+1,l).toCharArray();

        holders.add(w);
    }

    //假设a,b是假币，那么这次测量的结果集是什么
    public String compare(char a, char b) {
        StringBuilder sb = new StringBuilder();
        for (Weightings w : holders) {
            sb.append(w.compare(a, b));
        }
        return sb.toString();
    }
}

//表示一次测量
class Weightings {
    char[] first;  //左边托盘放的硬币集合，
    char[] second; //右边

    //假设a,b是假币，那么这次测量的结果是什么
    public char compare(char a,char b) {
        int firstWeight = 0, secondWeight = 0;
        for(char c : first) {
            if(c == a || c == b)
                continue;
            firstWeight++;
        }
        for (char c : second) {
            if(c == a || c == b)
                continue;
            secondWeight++;
        }
        if(firstWeight == secondWeight) return '=';
        else if(firstWeight < secondWeight) return '<';
        else return '>';
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] inputs = line.split(",");

        int n = Integer.valueOf(inputs[0]);
        int m = Integer.valueOf(inputs[1]);

        WeightingsHolder weightingsHolder = new WeightingsHolder();

        for(int i = 0; i < m; i++) {
            line = sc.nextLine();
            weightingsHolder.addWeightings(line);
        }

        LinkedHashMap<String, List<String>> result = new LinkedHashMap<String, List<String>>();

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                char a = (char)('A' + i);
                char b = (char)('A' + j);
                String s = weightingsHolder.compare(a, b);
//                System.out.println(a + "" + b + " : " + s);
                if(!result.containsKey(s)) {
                    result.put(s,new ArrayList<String>());
                }
                result.get(s).add(a +""+ b);
            }
        }

        ArrayList<String> outputs = new ArrayList<String>();

        Iterator iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String s = (String) entry.getKey();
            List<String> list = (ArrayList<String>)entry.getValue();
            if(list.size() <= 1)
                continue;
            int size = list.size();
            for(int i = 0; i < size - 1; i++) {
                for(int j = i + 1; j < size; j++)
//                    System.out.println(list.get(i)+"="+list.get(j));
                    outputs.add(list.get(i)+"="+list.get(j));
            }
        }

        Collections.sort(outputs);

        for(int i = 0; i < outputs.size(); i++) {
            System.out.print(outputs.get(i));
            if (i != outputs.size() - 1) {
                System.out.println();
            }
        }
    }
}
