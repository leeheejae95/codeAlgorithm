package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class HowToQueuePractice {

    public int factorial(int n) {
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++) nums.add(i);

        k--;
        int idx = 0;
        while(!nums.isEmpty()) {
            int result = factorial(nums.size()-1);
            int selected = (int)(k/result); // 현재 자릿수
            answer[idx++] = nums.get(selected);
            nums.remove(selected);
            k%=result; // 다음 자릿수
        }

        return answer;
    }

    public static void main(String[] args) {
        HowToQueuePractice T = new HowToQueuePractice();
        System.out.println(Arrays.toString(T.solution(3,5)));
    }
}
