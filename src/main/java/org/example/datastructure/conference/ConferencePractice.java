package org.example.datastructure.conference;

import java.util.*;

public class ConferencePractice {
    public int solution(int n, int[][] meetings) {
        int answer = 0;
        int[] ch = new int[n];
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i=0; i<n; i++) rooms.add(i);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        for(int[] m : meetings) {
            while(!pq.isEmpty() && pq.peek()[0]<=m[0]) rooms.add(pq.poll()[1]);
            if(!rooms.isEmpty()) {
                int room = rooms.pollFirst();
                ch[room]++;
                pq.offer(new int[]{m[1], room});
            } else {
                int[] e = pq.poll();
                ch[e[1]]++;
                pq.offer(new int[]{e[0]+(m[1]-m[0]), e[1]});
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
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
