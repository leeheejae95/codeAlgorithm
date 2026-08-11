package programers.code.codingtestproblem.lv2;

import java.util.*;

public class MakeTheSumsOfTwoQueuesEqual {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1=0,sum2=0;
        for(int x : queue1) sum1 += x; // 2
        for(int x : queue2) sum2 += x; // 6
        long target = (sum1+sum2)/2; // 15
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int x : queue1) q1.offer(x);
        for(int x : queue2) q2.offer(x);
        int maxCount = (queue1.length + queue2.length) * 2; // while문 종료 카운트
        while(answer<=maxCount) {
            if(sum1==target && sum2==target) return answer;
            if(sum1 > target) { // 2 > 4
                int x = q1.poll();
                q2.offer(x);
                sum1 -= x;
                sum2 += x;
            } else if(sum2 > target){ // 6 > 4
                int x = q2.poll();
                q1.offer(x);
                sum1 += x;
                sum2 -= x;
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MakeTheSumsOfTwoQueuesEqual T = new MakeTheSumsOfTwoQueuesEqual();
        System.out.println(T.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(T.solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
