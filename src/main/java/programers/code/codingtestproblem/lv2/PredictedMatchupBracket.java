package programers.code.codingtestproblem.lv2;

public class PredictedMatchupBracket {

    public int solution(int n, int a, int b) {
        int answer = 0;
        while(a != b) {
            a = (a+1) / 2;
            b = (b+1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        PredictedMatchupBracket T = new PredictedMatchupBracket();
        System.out.println(T.solution(8,4,7));
    }
}
