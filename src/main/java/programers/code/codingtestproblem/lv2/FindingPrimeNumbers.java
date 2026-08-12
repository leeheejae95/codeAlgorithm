package programers.code.codingtestproblem.lv2;

import java.util.*;

public class FindingPrimeNumbers {

    int[] ch;
    HashSet<Integer> set;
    public boolean isPrime(String current) {
        if(current.isEmpty() || Integer.parseInt(current)<2) return false;
        for(int i=2; i*i<=Integer.parseInt(current);i++) {
            if(Integer.parseInt(current)%i==0) {
                return false;
            }
        }
        return true;
    }
    public void DFS(String current, String numbers) {
        if(!current.isEmpty() && isPrime(current)) {
            set.add(Integer.parseInt(current));
        }

        for(int i=0;i<numbers.length();i++) {
            if(ch[i]==0) {
                ch[i]=1;
                DFS(current+numbers.charAt(i), numbers);
                ch[i]=0;
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
        FindingPrimeNumbers T = new FindingPrimeNumbers();
        System.out.println(T.solution("17"));
        System.out.println(T.solution("011"));
    }
}
