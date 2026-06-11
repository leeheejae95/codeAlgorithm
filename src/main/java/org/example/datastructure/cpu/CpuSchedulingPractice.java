package org.example.datastructure.cpu;

import java.util.*;

public class CpuSchedulingPractice {
    public int[] solution(int[][] tasks){ // 호출 / 실행
//        int[] answer = {};
        int n = tasks.length;
        int[] answer = new int[n];
        int[][] sorted = new int[n][3]; // {호출, 실행, 작업번호}
        for(int i=0;i<n;i++) {
            sorted[i][0] = tasks[i][0];
            sorted[i][1] = tasks[i][1];
            sorted[i][2] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]); // {실행시간, 작업번호}
        Arrays.sort(sorted, (a,b)->a[0]-b[0]); // 호출순으로 정렬
        int time = 0;
        int cnt = 0;
        int idx = 0;
        while(cnt < n) {
            if(pq.isEmpty() && time<sorted[idx][0]) time = sorted[idx][0];
            while(idx<n && sorted[idx][0]<=time) {
                pq.add(new int[]{sorted[idx][1], sorted[idx][2]}); // {실행, 작업번호}
                idx++;
            }
            int[] exit = pq.poll();
            time += exit[0]; // 실행시간 누적
            answer[cnt++] = exit[1]; // 작업번호 넣기
        }

        return answer;
    }

    public static void main(String[] args){
        CpuSchedulingPractice T = new CpuSchedulingPractice();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
