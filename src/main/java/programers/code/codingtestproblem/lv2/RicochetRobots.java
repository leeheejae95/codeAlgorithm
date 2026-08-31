package programers.code.codingtestproblem.lv2;

import java.util.*;

public class RicochetRobots {

    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        int x=0,y=0;
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        int[][] ch = new int[n][m];
        char[][] boardMap = new char[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) boardMap[i][j] = board[i].charAt(j);

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(boardMap[i][j]=='R') {
                    x=i;
                    y=j;
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
                int[] cur = q.poll(); // 로봇좌표
                for(int k=0;k<4;k++) {
                    int nx = cur[0];
                    int ny = cur[1];
                    // 벽이나 장애물 만날 때까지 미끄러짐
                    while(nx>=0 && nx<n && ny>=0 && ny<m && boardMap[nx][ny]!='D') {
                        nx+=dx[k];
                        ny+=dy[k];
                    }
                    // 한 칸 되돌아가기 (벽/장애물 직전 위치)
                    nx-=dx[k];
                    ny-=dy[k];
                    if(boardMap[nx][ny]=='G') return L+1;
                    if(ch[nx][ny]==0) {
                        ch[nx][ny]=1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        RicochetRobots T = new RicochetRobots();
        System.out.println(T.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(T.solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }
}
