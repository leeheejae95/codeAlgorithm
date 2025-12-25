package org.example.datastructure.cpu;

import java.util.*;

public class CpuScheduling {
    public int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++){
            programs.add(new int[]{tasks[i][0], tasks[i][1], i}); // 도착, 실행, 인덱스
        }
        programs.sort((a, b) -> a[0] - b[0]); // 도착(호출) 시간 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // 실행시간이 짧은 작업을 먼저 실행
        int fT = 0, idx = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){ // 스케줄링 문제는 programs, pq가 비어 있을 때까지 계속 돌아야 한다.
            if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= fT){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]}); // 실행, 인덱스
            }
            int[] ex = pq.poll();
            fT = fT + ex[0];
            answer[idx++] = ex[1]; // answer에 작업 번호 넣기
        }

        return answer;
    }

    public static void main(String[] args){
        CpuScheduling T = new CpuScheduling();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
