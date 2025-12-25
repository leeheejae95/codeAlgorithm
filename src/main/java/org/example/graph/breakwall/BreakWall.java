package org.example.graph.breakwall;

import java.util.*;
// 다익스트라 문제
public class BreakWall {
    public int solution(int[][] board) {
        int answer = 0;
        int[]dx={-1, 0, 1, 0};
        int[]dy={0, 1, 0,-1};
        int n=board.length;
        int m=board[0].length;
        int[][]cost =new int[n][m];
        for(int i =0; i <n; i++)Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[0][0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a, b)->a[2]-b[2]); // 비용이 작은 순으로 정렬
        pq.add(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[]cur =pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int k=0; k<4; k++) {
                int nx=cur[0]+dx[k];
                int ny=cur[1]+dy[k];
                if(nx<0||nx>=n||ny<0||ny>=m) continue; // 범위 넘어가면 볼 필요 없음
                if(board[nx][ny]==0 && cost[nx][ny]>cur[2]) { // 비용이 0일때
                    cost[nx][ny]=cur[2];
                    pq.offer(new int[]{nx, ny, cur[2]});
                }
                else if(board[nx][ny]==1 && cost[nx][ny]>cur[2]+1){ // 갈려고 하는 지점이 벽이라서 +1 해줘야됨
                    cost[nx][ny]=cur[2]+1;
                    pq.offer(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        return cost[n-1][m-1];
//        return answer;
    }

    public static void main(String[] args){
        BreakWall T = new BreakWall();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
