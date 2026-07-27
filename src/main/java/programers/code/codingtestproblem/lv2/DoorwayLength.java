package programers.code.codingtestproblem.lv2;

import java.util.*;

public class DoorwayLength {

    public int solution(String dirs) {
        int answer = 0, x=0,y=0;
        HashSet<String> set = new HashSet<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(char c : dirs.toCharArray()) {
            int d = c=='U'?0:c=='D'?1:c=='R'?2:3;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx<-5 || nx>5 || ny<-5 || ny>5) continue;

            // HashSet에 갔던길 넣기
            String path1 = x+","+y+"->"+nx+","+ny; // 0,0->0,1
            String path2 = nx+","+ny+"->"+x+","+y; // 0,1->0,0

            if(!set.contains(path1)) {
                set.add(path1);
                set.add(path2);
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    public static void main(String[] args) {
        DoorwayLength T = new DoorwayLength();
        System.out.println(T.solution("ULURRDLLU"));
        System.out.println(T.solution("LULLLLLLU"));
    }
}
