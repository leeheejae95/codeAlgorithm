package programers.code.codingtestproblem.lv2;

import java.util.*;

public class HowToQueue {

    public long factorial(int n) {
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i=1;i<=n;i++) numList.add(i);
        k--;
        int idx = 0;
        while(!numList.isEmpty()) {
            long fact = factorial(numList.size()-1);
            int selected = (int)(k/fact);
            answer[idx++] = numList.get(selected);
            numList.remove(selected);
            k %= fact; // 다음 자릿수 구하기
        }

        return answer;
    }

    public static void main(String[] args) {
        HowToQueue T = new HowToQueue();
        System.out.println(Arrays.toString(T.solution(3,5)));
    }
}
