package programers.code.codingtestproblem.lv2.practice;

public class NumberRepresentationPractice {

    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++) {
            int sum = 0;
            for(int j=i;j<=n;j++) {
                sum += j;
                if(sum==n) {
                    answer++;
                    break;
                }
                if(sum > n) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberRepresentationPractice T = new NumberRepresentationPractice();
        System.out.println(T.solution(15));
    }
}
