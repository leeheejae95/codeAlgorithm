package programers.code.codingtestproblem.lv2;

import java.util.*;

public class Spicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위큐
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int x : scoville) q.offer(x);

        while(q.peek() < K) {
            if(q.size()<2) return -1;
            int first = q.poll(); // 3
            int second = q.poll(); // 5
            q.offer(first+(second*2)); // 9 10 12 13
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Spicy T = new Spicy();
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
