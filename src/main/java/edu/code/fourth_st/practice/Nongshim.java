package edu.code.fourth_st.practice;

import java.util.*;

public class Nongshim {
    public int solution(int stock, int[] dateArray, int[] suppArray, int k) {
        int answer = 0;
        int n = dateArray.length;
        int[][] list = new int[n][2];
        for(int i = 0; i < n; i++) {
            list[i][0] = dateArray[i];
            list[i][1] = suppArray[i];
        }
        Arrays.sort(list, (a, b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while(stock < k) {
            while(idx < n && list[idx][0] <= stock) {
                pq.offer(list[idx][1]);
                idx++;
            }
            if(pq.isEmpty()) return -1;
            answer++;
            stock += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Nongshim T = new Nongshim();

        System.out.println("정답 = 2 / 현재 풀이 값 = " +
                T.solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println("정답 = 4 / 현재 풀이 값 = " +
                T.solution(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " +
                T.solution(2, new int[]{1, 10}, new int[]{10, 100}, 11));
    }
}
