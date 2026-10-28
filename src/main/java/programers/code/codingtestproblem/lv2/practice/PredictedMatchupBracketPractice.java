package programers.code.codingtestproblem.lv2.practice;

public class PredictedMatchupBracketPractice {

    public int solution(int n, int a, int b) {
        int answer = 0;
        while(a!=b) {
            a = (a+1) / 2;
            b = (b+1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        PredictedMatchupBracketPractice T = new PredictedMatchupBracketPractice();
        System.out.println(T.solution(8,4,7));
    }
}
