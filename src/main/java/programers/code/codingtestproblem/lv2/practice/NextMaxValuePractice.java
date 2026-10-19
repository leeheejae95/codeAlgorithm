package programers.code.codingtestproblem.lv2.practice;

public class NextMaxValuePractice {

    public int solution(int n) {
        int answer = n+1;
        int cnt = Integer.bitCount(n);

        while(Integer.bitCount(answer) != cnt) answer++;

        return answer;
    }

    public static void main(String[] args) {
        NextMaxValuePractice T = new NextMaxValuePractice();
        System.out.println(T.solution(78));
        System.out.println(T.solution(15));
    }
}
