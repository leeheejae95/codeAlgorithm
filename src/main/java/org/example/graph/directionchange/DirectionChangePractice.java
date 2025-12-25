package org.example.graph.directionchange;

import java.util.*;

public class DirectionChangePractice {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.offer(new int[]{0, 0,0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dis = board[cur[0]][cur[1]]-1;
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int k=0; k<4; k++) {
                int nx =  cur[0]+dx[k];
                int ny = cur[1]+dy[k];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(k==dis && cost[nx][ny] > cur[2]) {
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx,ny, cost[nx][ny]});
                } else {
                    if(cost[nx][ny] > cur[2]+1) {
                        cost[nx][ny] = cur[2]+1;
                        pq.offer(new int[]{nx,ny, cost[nx][ny]});
                    }
                }
            }
        }
        return cost[n-1][m-1];
//        return answer;
    }

    public static void main(String[] args){
        DirectionChangePractice T = new DirectionChangePractice();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
