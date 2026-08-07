package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class CountingPrimeNumbersPractice {

    public boolean isValid(int number) { // 211
        if(number < 2) return false;
        for(int i=2;i*i<=number;i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String[] numArr = Integer.toString(n,k).split("0");
        for(String num : numArr) { // 211 2 1 1 11
            if(num.length() == 0) continue;
            int number = Integer.parseInt(num);
            if(isValid(number)) {
                answer++;
            };
        }

        return answer;
    }

    public static void main(String[] args) {
        CountingPrimeNumbersPractice T = new CountingPrimeNumbersPractice();
        System.out.println(T.solution(437674,3));
        System.out.println(T.solution(110011,10));
    }
}