package programers.code.codingtestproblem.lv2;

import java.util.*;

public class CheckSocialDistancingGuidelines {

    public int[] solution(String[][] places) {
        // P : 응시자 앉은 자리
        // O : 빈 테이블
        // X : 파티션
        int n = places.length;
        int m = places[0].length;
        int x=0,y=0;
        int[] answer = new int[5];
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        char[][] room = new char[5][5];
        Queue<int[]> q = new LinkedList<>();
        for(int r=0;r<5;r++) { // 0~5번 대기실
            for(int i=0;i<n;i++) for(int j=0;j<m;j++) room[i][j] = places[r][i].charAt(j); // char 배열에 넣기

            boolean isCheck = true;
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(room[i][j]=='P') {
                        x = i;
                        y = j;
                        int[][] ch = new int[5][5];
                        q.offer(new int[]{i,j});
                        ch[i][j] = 1;
                        while(!q.isEmpty()) {
                            int[] curr = q.poll();
                            for(int k=0;k<4;k++) { // 4방향
                                int nx = curr[0] + dx[k];
                                int ny = curr[1] + dy[k];
                                if(nx<0|| nx>=n || ny<0|| ny>=m) continue; // 범위 벗어나면 패쓰
                                if(room[nx][ny]=='X') continue; // X(파티션)이면 패쓰
                                int dist = Math.abs(nx-x) + Math.abs(ny-y); // 거리
                                if(dist>0 && dist<=2 && room[nx][ny]=='P') { isCheck = false; break; } // 2 이하로 앉을경우 false
                                if(ch[nx][ny]==0 && dist<2) {
                                    ch[nx][ny] = 1;
                                    q.offer(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                }
            }
            answer[r] = isCheck ? 1 : 0; // while문 종료후 대기실 준수여부 넣기
        }

        return answer;
    }

    public static void main(String[] args) {
        CheckSocialDistancingGuidelines T = new CheckSocialDistancingGuidelines();
        System.out.println(Arrays.toString(T.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }
}
