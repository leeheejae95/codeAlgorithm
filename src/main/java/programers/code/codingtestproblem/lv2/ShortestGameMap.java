package programers.code.codingtestproblem.lv2;

import java.util.*;

public class ShortestGameMap {
    public int solution(int[][] maps) {
//        int anwer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] ch = new int[n][m];
        int[][] dist = new int[n][m];
        ch[0][0] = 1;
        dist[0][0] = 1;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()) {
            int[] x = queue.poll();
            for(int k=0;k<4;k++) {
                int nx = x[0] + dx[k];
                int ny = x[1] + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    dist[nx][ny] = dist[x[0]][x[1]] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }

        return dist[n-1][m-1]==0 ? -1 : dist[n-1][m-1];
    }

    public static void main(String[] args) {
        ShortestGameMap T = new ShortestGameMap();
        System.out.println(T.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(T.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }

}
