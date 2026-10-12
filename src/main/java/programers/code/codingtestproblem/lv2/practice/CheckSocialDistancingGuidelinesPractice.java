package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class CheckSocialDistancingGuidelinesPractice {

    public int[] solution(String[][] places) {
        // P : 응시자 앉은 자리
        // O : 빈 테이블
        // X : 파티션
        int n = places.length;
        int m = places[0].length;
        int x=0,y=0;
//        int[] answer = {};
        int[] answer = new int[5];
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        char[][] placesConverted = new char[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int z=0;z<n;z++) { // 대기실
            for(int i=0;i<n;i++) for(int j=0;j<m;j++) placesConverted[i][j] = places[z][i].charAt(j);

            boolean isCheck = true;
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(placesConverted[i][j]=='P') {
                        x = i;
                        y = j;
                        int[][] ch = new int[n][m];
                        q.offer(new int[]{x,y});
                        ch[x][y] = 1;
                        while(!q.isEmpty()) {
                            int size = q.size();
                            for(int r=0;r<size;r++) {
                                int[] curr = q.poll();
                                for(int k=0;k<4;k++) {
                                    int nx = curr[0]+dx[k];
                                    int ny = curr[1]+dy[k];
                                    if(nx<0||nx>=n||ny<0||ny>=m) continue;
                                    if(placesConverted[nx][ny]=='X') continue;
                                    int dist = Math.abs(nx-x)+Math.abs(ny-y); // 맨해튼 거리
                                    if(dist>0 && dist<=2 && placesConverted[nx][ny]=='P') { isCheck = false; break; }
                                    if(ch[nx][ny]==0 && dist<2) {
                                        ch[nx][ny] = 1;
                                        q.offer(new int[]{nx,ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answer[z] = isCheck ? 1 : 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        CheckSocialDistancingGuidelinesPractice T = new CheckSocialDistancingGuidelinesPractice();
        System.out.println(Arrays.toString(T.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }
}
