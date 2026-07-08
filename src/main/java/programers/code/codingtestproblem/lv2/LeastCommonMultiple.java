package programers.code.codingtestproblem.lv2;

public class LeastCommonMultiple {

    public int lcm(int a, int b) { // 최소공배수
        return a*b / gcd(a,b); // 2*6 / gcd(2,6) -> 6*2 / gcd(6,2)
    }

    public int gcd(int a, int b) { // 최대공약수
        if(b==0) return a;
        return gcd(b, a%b); // gcd(6,2) -> gcd(6,0)
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1;i<arr.length;i++) {
            answer = lcm(answer, arr[i]); // 2,6
        }

        return answer;
    }

    public static void main(String[] args) {
        LeastCommonMultiple T = new LeastCommonMultiple();
        System.out.println(T.solution(new int[]{2,6,8,14}));
        System.out.println(T.solution(new int[]{1,2,3}));
    }
}
