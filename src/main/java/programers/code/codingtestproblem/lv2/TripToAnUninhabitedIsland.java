package programers.code.codingtestproblem.lv2;

import java.util.*;

public class TripToAnUninhabitedIsland {

    public int[] solution(String[] maps) {
//        int[] answer = {};
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = maps.length;
        int m= maps[0].length();
        int x=0,y=0;
        char[][] mapsConverted = new char[n][m];
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> sumList = new ArrayList<>();
        int[][] ch = new int[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) mapsConverted[i][j] = maps[i].charAt(j);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(Character.isDigit(mapsConverted[i][j]) && ch[i][j]==0) {
                    x = i;
                    y = j;
                    int sum = mapsConverted[x][y] - '0';
                    ch[x][y] = 1;
                    q.offer(new int[]{x,y});
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int r=0;r<size;r++) {
                            int[] curr = q.poll();
                            for(int k=0;k<4;k++) {
                                int nx = curr[0] + dx[k];
                                int ny = curr[1] + dy[k];
                                if(nx>=0 && nx<n && ny>=0 && ny<m && ch[nx][ny]==0 && mapsConverted[nx][ny] != 'X') {
                                    ch[nx][ny] = 1;
                                    sum += mapsConverted[nx][ny]-'0';
                                    q.offer(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    sumList.add(sum);
                }
           }
        }

        if(sumList.isEmpty()) return new int[]{-1};
        Collections.sort(sumList);
        int[] answer = new int[sumList.size()];
        for(int i=0;i< sumList.size();i++) {
            answer[i] = sumList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        TripToAnUninhabitedIsland T = new TripToAnUninhabitedIsland();
        System.out.println(Arrays.toString(T.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"})));
//        System.out.println(Arrays.toString(T.solution(new String[]{"XXX","XXX","XXX"})));
    }
}
