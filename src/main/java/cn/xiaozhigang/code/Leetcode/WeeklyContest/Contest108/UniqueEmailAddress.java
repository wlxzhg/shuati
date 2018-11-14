package cn.xiaozhigang.code.Leetcode.WeeklyContest.Contest108;

import java.util.HashSet;

public class UniqueEmailAddress {
    public static void main(String[] args) {
//        (new UniqueEmailAddress()).numUniqueEmails("test.email+alex@leetcode.com");
        System.out.println((new UniqueEmailAddress()).numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (String email : emails) {
            set.add(numUniqueEmails(email));
        }

        return set.size();
    }

    public String numUniqueEmails(String email) {
        char[] array = email.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0,length = array.length;
        for(; index < length; index++) {
            if(array[index] == '@') {
                break;
            }
            if(array[index] == '+') {
                while (array[index] != '@')
                    index++;
                break;
            }
            if(array[index] == '.') {
                continue;
            }
            sb.append(array[index]);
        }
        while (index < length)
            sb.append(array[index++]);
        return sb.toString();
    }
}
