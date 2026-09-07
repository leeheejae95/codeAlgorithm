package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class MazeEscapePractice {

    public int BFS(char[][] mapsChars, char c, int[] location, int n, int m) {
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        int[][] ch = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(location);
        ch[location[0]][location[1]] = 1;
        int L = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                for(int k=0;k<4;k++) {
                    int nx = curr[0] + dx[k];
                    int ny = curr[1] + dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && ch[nx][ny]==0 && mapsChars[nx][ny] != 'X') {
                        if(mapsChars[nx][ny]==c) return L+1;
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
        int x1=0,y1=0,x2=0,y2=0;
        int n = maps.length;
        int m = maps[0].length();
        char[][] mapsConverted = new char[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) mapsConverted[i][j] = maps[i].charAt(j);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mapsConverted[i][j]=='S') {
                    x1=i;
                    y1=j;
                } else if(mapsConverted[i][j]=='L') {
                    x2=i;
                    y2=j;
                }
            }
        }

        int[] startLocation = {x1,y1};
        int[] leverLocation = {x2,y2};
        int lever = BFS(mapsConverted,'L',startLocation,n,m);
        int end = BFS(mapsConverted,'E',leverLocation,n,m);
        if(lever == -1 || end == -1) return -1;
        answer = lever+end;

        return answer;
    }

    public static void main(String[] args) {
        MazeEscapePractice T = new MazeEscapePractice();
        System.out.println(T.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(T.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    }
}
