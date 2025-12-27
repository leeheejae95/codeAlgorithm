package boj.code;

import java.util.*;

public class CardCoalescencePlay {
    public int solution(int m, int n, int[] nums) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++) pq.add((long) nums[i]); // 2 3 6

        long z = 0;
        for(int i=0; i<n; i++) {
            long x = pq.poll(); // 2
            long y = pq.poll(); // 3
            z = x + y; // 5
            pq.add(z); // 5 6
            pq.add(z); // 5 5 6
        }
        for(long a : pq) {
            answer += a;
        }

        return answer;
    }

    public static void main(String[] args){
        CardCoalescencePlay T = new CardCoalescencePlay();
        int[] nums = {3,2,6};
        System.out.println(T.solution(3,1, nums));

        int[] nums2 = {4,2,3,1};
        System.out.println(T.solution(4,2, nums2));
    }
}
