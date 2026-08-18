package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class MakeTheSumsOfTwoQueuesEqualPractice {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1=0,sum2=0;
        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();
        for(int x : queue1) queueOne.offer(x);
        for(int x : queue2) queueTwo.offer(x);
        for(int x : queue1) sum1 += x;
        for(int x : queue2) sum2 += x;
        long total = (sum1+sum2)/2;
        int maxLen = (queueOne.size() + queueTwo.size())*2;
        while(answer<=maxLen) {
            if(sum1==total && sum2==total) return answer;
            if(sum1>total) {
                int x = queueOne.poll();
                queueTwo.offer(x);
                sum1-= x;
                sum2+=x;
            } else if(sum2>total) {
                int x = queueTwo.poll();
                queueOne.offer(x);
                sum2-=x;
                sum1+=x;
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MakeTheSumsOfTwoQueuesEqualPractice T = new MakeTheSumsOfTwoQueuesEqualPractice();
        System.out.println(T.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(T.solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
