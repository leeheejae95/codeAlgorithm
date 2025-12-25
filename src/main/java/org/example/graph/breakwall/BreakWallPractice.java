package org.example.graph.breakwall;

import java.util.*;

// 다익스트라 문제
public class BreakWallPractice {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] costs = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(costs[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()) {
            int[] cur =  pq.poll();
            if(cur[2] > costs[cur[0]][cur[1]]) continue;
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(board[nx][ny]==0 && cur[2] < costs[nx][ny]) {
                    costs[nx][ny] = cur[2];
                    pq.offer(new int[]{nx, ny, costs[nx][ny]});
                } else if(board[nx][ny]==1 && costs[nx][ny]>cur[2]+1){ // 갈려고 하는 지점이 벽이라서 +1 해줘야됨
                    costs[nx][ny]=cur[2]+1;
                    pq.offer(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        return costs[n-1][m-1];

//        return answer;
    }

    public static void main(String[] args){
        BreakWallPractice T = new BreakWallPractice();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
