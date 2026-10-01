package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class TripToAnUninhabitedIslandPractice {

    public int[] solution(String[] maps) {
//        int[] answer = {};
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        int x=0,y=0;
        int n = maps.length;
        int m = maps[0].length();
        int[][] ch = new int[n][m];
        char[][] mapsConverted = new char[n][m];
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) mapsConverted[i][j] = maps[i].charAt(j);

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(Character.isDigit(mapsConverted[i][j]) && ch[i][j]==0) {
                    x=i;
                    y=j;
                    int sum = mapsConverted[x][y]-'0';
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{x,y});
                    ch[x][y] = 1;
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int r=0;r<size;r++) {
                            int[] curr = q.poll();
                            for(int k=0;k<4;k++) {
                                int nx = curr[0] + dx[k];
                                int ny = curr[1] + dy[k];
                                if(nx>=0 && nx<n && ny>=0 && ny<m && ch[nx][ny]==0 && mapsConverted[nx][ny]!='X') {
                                    ch[nx][ny] = 1;
                                    sum += mapsConverted[nx][ny]-'0';
                                    q.offer(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    nums.add(sum);
                }
            }
        }

        if(nums.isEmpty()) return new int[]{-1};

        Collections.sort(nums);
        int[] answer = new int[nums.size()];
        for(int i=0;i< nums.size();i++) answer[i] = nums.get(i);

        return answer;
    }

    public static void main(String[] args) {
        TripToAnUninhabitedIslandPractice T = new TripToAnUninhabitedIslandPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"XXX","XXX","XXX"})));
    }
}
