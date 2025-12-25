package org.example.code;

import java.util.*;

public class Problem {
    public ArrayList<Integer> solution(int n, int[][] board) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 1은 집이 있는 곳 0은 집이 없는곳
        // 상하좌우 좌표
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] ch = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1 && ch[i][j] == 0) {
                    q.offer(new int[]{i,j}); // 여기 방문했어
                    ch[i][j] = 1; // 방문처리
                    int L = 1; // 방문 했으니깐 1부터 시작
                    while(!q.isEmpty()){
                        int[] pos = q.poll();
                        for(int k=0; k<4; k++) {
                            int nx = pos[0] + dx[k];
                            int ny = pos[1] + dy[k];
                            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if(board[nx][ny] == 1 && ch[nx][ny]==0) { // 집이 있음
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx,ny});
                                L++;
                            }
                        }
                    }
                    list.add(L);
                }
            }
        }

        for(int x : list) {
            answer.add(x);
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args){
        Problem T = new Problem();
        ArrayList<Integer> res = T.solution(7,new int[][]{
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}
        });
        System.out.println(res.size());
        for (int x : res) {
            System.out.println(x);
        }
    }
}

