package programers.code.codingtestproblem.lv2;

public class LandGrabbingGame {

    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        for(int i=1;i<n;i++) { // 행
            for(int j=0;j<4;j++) { // 열
                int max = 0;
                for(int k=0;k<4;k++) {
                    if(k==j) continue;
                    max = Math.max(max, land[i-1][k]);
                }
                land[i][j] += max;
            }
        }

        for(int i=0;i<4;i++) answer = Math.max(answer, land[n-1][i]);

        return answer;
    }

    public static void main(String[] args) {
        LandGrabbingGame T = new LandGrabbingGame();
        System.out.println(T.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
