package programers.code.codingtestproblem.lv2;

public class FibonacciNum {

    public int solution(int n) {
        int answer = 0;
        int num1 = 1;
        int num2 = 1;
        int[] numArr = new int[n+1];
        numArr[1] = num1;
        numArr[2] = num2;
        for(int i=3;i<=n;i++) {
            numArr[i] = (numArr[i-1] + numArr[i-2]) % 1234567;
            answer = numArr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        FibonacciNum T = new FibonacciNum();
        System.out.println(T.solution(3));
        System.out.println(T.solution(5));
    }
}
