package programers.code.codingtestproblem.lv2.practice;

public class TwoXNTilingPractice {

    public int solution(int n) {
        int answer = 0;
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i=3;i<=n;i++) result[i] = (result[i-1]+result[i-2])%1000000007;
        answer = result[n];

        return answer;
    }

    public static void main(String[] args) {
        TwoXNTilingPractice T = new TwoXNTilingPractice();
        System.out.println(T.solution(4));
    }
}