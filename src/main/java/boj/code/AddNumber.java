package boj.code;

import java.util.*;

public class AddNumber {
    public ArrayList<Integer> solution(int n, int[][] board) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] ch = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    q.offer(new int[]{i,j});
                    answer = 1; // 현재 좌표에 방문했으니 1부터...
                    while(!q.isEmpty()){
                        int[] prev =  q.poll(); // x=0 y=1
                        for(int k=0; k<4; k++) {
                            int nx = prev[0] + dx[k];
                            int ny = prev[1] + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(board[nx][ny] == 1 && ch[nx][ny] == 0) {
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx,ny});
                                answer++;
                            }
                        }
                    }
                    list.add(answer);
                }
            }
        }

        return list;
    }

    public static void main(String[] args){
        AddNumber T = new AddNumber();
        ArrayList<Integer> list = T.solution(7, new int[][]{
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}
        });
        System.out.println(list.size());
        for(int x : list) System.out.println(x);
    }
}
