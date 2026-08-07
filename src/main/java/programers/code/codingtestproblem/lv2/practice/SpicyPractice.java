package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class SpicyPractice {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville) pq.offer(x); // 1 2 3 9 10 12

        while(pq.peek()<K) {
            if(pq.size() < 2) return -1;
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + (second*2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SpicyPractice T = new SpicyPractice();
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
