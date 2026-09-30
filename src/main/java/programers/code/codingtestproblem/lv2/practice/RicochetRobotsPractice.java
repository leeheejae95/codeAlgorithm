package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class RicochetRobotsPractice {

    public int solution(String[] board) {
        int answer = 0;
        int x=0,y=0;
        int n = board.length;
        int m = board[0].length();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] ch = new int[n][m];
        char[][] boardConverted = new char[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) boardConverted[i][j] = board[i].charAt(j);

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(boardConverted[i][j]=='R') {
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        ch[x][y]=1;
        int L = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                for(int k=0;k<4;k++) {
                    int nx = curr[0]; // 0
                    int ny = curr[1]; // 6
                    while(nx>=0 && nx<n && ny>=0 && ny<m && boardConverted[nx][ny]!='D') {
                        nx+=dx[k];
                        ny+=dy[k];
                    }
                    // 부딪히면 직전 이동 위치로 이동
                    nx-=dx[k];
                    ny-=dy[k];
                    if(boardConverted[nx][ny]=='G') return L+1;
                    if(ch[nx][ny]==0) {
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        RicochetRobotsPractice T = new RicochetRobotsPractice();
        System.out.println(T.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(T.solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }
}
