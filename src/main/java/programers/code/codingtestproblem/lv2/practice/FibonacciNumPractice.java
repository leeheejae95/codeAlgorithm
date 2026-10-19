package programers.code.codingtestproblem.lv2.practice;

public class FibonacciNumPractice {

    public int solution(int n) {
        int answer = 0;
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i=2;i<=n;i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        answer = fibo[n];


        return answer;
    }

    public static void main(String[] args) {
        FibonacciNumPractice T = new FibonacciNumPractice();
        System.out.println(T.solution(3));
        System.out.println(T.solution(5));
    }
}
