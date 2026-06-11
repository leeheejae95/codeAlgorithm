package org.example.datastructure.conference;

import java.util.*;

public class ConferencePractice {
    public int solution(int n, int[][] meetings) {
        int answer = 0;
        int[] ch = new int[n];
        PriorityQueue<Integer> roomPQ = new PriorityQueue<>(); // 회의실 번호
        for(int i=0;i<n;i++) roomPQ.add(i); // 0, 1
        PriorityQueue<int[]> conferencePQ = new PriorityQueue<>((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]); // 사용중인 회의실{끝나는시간, 회의실}
        Arrays.sort(meetings, (a,b)->a[0]-b[0]); // 시작시간 기준으로 오름차순 정렬
        for(int[] meet : meetings) { // {0,5}, {2.7}, {4,5}, {7, 10}, {9, 12}
            while(!conferencePQ.isEmpty() && conferencePQ.peek()[0] <= meet[0]) roomPQ.add(conferencePQ.poll()[1]); // 회의실 반납
            if(!roomPQ.isEmpty()) { // 회의실 존재
                int roomInfo = roomPQ.poll();
                conferencePQ.add(new int[]{meet[1], roomInfo});
                ch[roomInfo]++;
            } else { // 회의실이 없음
                int[] exit = conferencePQ.poll();
                conferencePQ.add(new int[]{exit[0]+(meet[1]-meet[0]), exit[1]});
                ch[exit[1]]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(ch[i] > max) {
                max = ch[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        ConferencePractice T = new ConferencePractice();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
