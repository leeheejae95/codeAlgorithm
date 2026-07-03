package programers.code.codingtestproblem.lv2;

public class NextMaxValue {

    public int solution(int n) {
        int answer = n + 1; // 79
        int cnt = Integer.bitCount(n);

        while(Integer.bitCount(answer) != cnt) answer++;

        return answer;
    }

    public static void main(String[] args) {
        NextMaxValue T = new NextMaxValue();
        System.out.println(T.solution(78));
        System.out.println(T.solution(15));
    }
}
