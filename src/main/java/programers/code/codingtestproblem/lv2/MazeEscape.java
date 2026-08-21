package programers.code.codingtestproblem.lv2;

import java.util.*;

public class MazeEscape {
    public int BFS(char[][] mapsConverted, int[] start, char target, int n, int m) {
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        int[][] ch = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0],start[1]}); // 좌표 넣기
        ch[start[0]][start[1]] = 1;
        int L = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int k=0;k<4;k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && ch[nx][ny]==0 && mapsConverted[nx][ny]!='X') {
                        if(mapsConverted[nx][ny]==target) return L+1;
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        int xS=0,yS=0,xL=0,yL=0;
        char[][] mapsConverted = new char[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) mapsConverted[i][j] = maps[i].charAt(j);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mapsConverted[i][j]=='S') { // S부터 시작
                    xS=i;
                    yS=j;
                } else if(mapsConverted[i][j]=='L') { // L부터 시작
                    xL=i;
                    yL=j;
                }
            }
        }
        int[] start = {xS,yS};
        int[] leave = {xL,yL};
        int disStoL = BFS(mapsConverted, start, 'L' , n, m);
        int disLtoE = BFS(mapsConverted, leave, 'E' , n, m);
        if(disStoL==-1 || disLtoE==-1) return -1;

        answer = disStoL + disLtoE;

        return answer;
    }

    public static void main(String[] args) {
        MazeEscape T = new MazeEscape();
        System.out.println(T.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(T.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    }
}
