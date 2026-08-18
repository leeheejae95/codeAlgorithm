package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class FindingPrimeNumbersPractice {

    int[] ch;
    HashSet<Integer> set;

    public boolean isValid(String cur) {
        int num = Integer.parseInt(cur);
        if(num < 2) return false;
        for(int i=2;i*i<=num;i++) if(num%i==0) return false;
        return true;
    }

    public void DFS(String cur, String numbers) {
        if(!cur.equals("") && isValid(cur)) set.add(Integer.parseInt(cur));
        for(int i=0;i<numbers.length();i++) {
            if(ch[i]==0) {
                ch[i] = 1;
                DFS(cur+numbers.charAt(i), numbers);
                ch[i] = 0;
            }
        }
    }

    public int solution(String numbers) {
        ch = new int[numbers.length()];
        set = new HashSet<>();
        DFS("",numbers);

        return set.size();
    }

    public static void main(String[] args) {
        FindingPrimeNumbersPractice T = new FindingPrimeNumbersPractice();
        System.out.println(T.solution("17"));
        System.out.println(T.solution("011"));
    }
}
