package programers.code.codingtestproblem.lv2;

import java.util.Arrays;

public class CountingPrimeNumbers {

    public boolean isValid(long num) {
        if(num < 2) return false;
        for(long i=2;i*i<=num;i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String[] converted = Integer.toString(n, k).split("0");
        System.out.println(Arrays.toString(converted));
        for(String s : converted) {
            if(s.length() == 0) continue;
            long num = Long.parseLong(s);
            if(isValid(num)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CountingPrimeNumbers T = new CountingPrimeNumbers();
        System.out.println(T.solution(437674,3));
        System.out.println(T.solution(110011,10));
    }
}