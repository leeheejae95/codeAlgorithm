package org.example.datastructure.conference;

import java.util.*;

public class Conference {
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] res = new int[n];
        // 우선순위 큐에는 끝나는 시간이랑 회의실 번호만 넣기
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i=0; i<n; i++) rooms.add(i); // 사용 가능한 회의실
        Arrays.sort(meetings,(a, b) -> a[0]-b[0]);
        for(int[] m : meetings) {
            while(!ends.isEmpty() && ends.peek()[0]<=m[0]) rooms.add(ends.poll()[1]); // 이미 끝나 회의실은 rooms에 넣기
            if(!rooms.isEmpty()) { // {0(회의 시작 시간),5(회의 끝나는 시간)}
                int room = rooms.pollFirst();
                res[room]++;
                ends.add(new int[]{m[1], room}); // 회의가 끝나는 시간, 회의실 넣기
            } else { // 기다렸다 회의실 들어가기
                int[] e = ends.poll();
                res[e[1]]++;
                ends.add(new int[]{e[0]+(m[1]-m[0]), e[1]});
            }
        }
        int maxi = 0;
        for(int i=0; i<n; i++) { // 가장 많이 들어간 회의실 구하기
            if(res[i] > maxi) {
                maxi = res[i];
                answer = i;
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Conference T = new Conference();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
