package programers.code.codingtestproblem.lv2;

public class TwoXNTiling {

    public int solution(int n) {
        int answer = 0;
        int[] til = new int[n+1];
        til[1] = 1;
        til[2] = 2;
        for(int i=3;i<=n;i++) til[i] = (til[i-1] + til[i-2]) % 1000000007;
        answer = Integer.parseInt(String.valueOf(til[n]));

        return answer;
    }

    public static void main(String[] args) {
        TwoXNTiling T = new TwoXNTiling();
        System.out.println(T.solution(4));
    }
}