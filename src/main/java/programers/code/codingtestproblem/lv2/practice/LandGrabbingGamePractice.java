package programers.code.codingtestproblem.lv2.practice;

public class LandGrabbingGamePractice {

    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length; // 3
        int m = land[0].length; // 4
        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                int max = 0;
                for(int k=0;k<m;k++) {
                    if(j==k) continue;
                    max = Math.max(max,land[i-1][k]);
                }
                land[i][j] += max;
            }
        }

        for(int i=0;i<4;i++) {
            answer = Math.max(answer, land[n-1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        LandGrabbingGamePractice T = new LandGrabbingGamePractice();
        System.out.println(T.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
