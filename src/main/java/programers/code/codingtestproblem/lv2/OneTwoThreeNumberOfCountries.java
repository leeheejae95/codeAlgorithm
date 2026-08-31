package programers.code.codingtestproblem.lv2;

public class OneTwoThreeNumberOfCountries {

    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int a = n % 3; // 현재 자리수
            if(a==0) {
                sb.append(4);
                n=n/3-1; // 다음 자리수
            } else {
                sb.append(a);
                n=n/3; // 다음 자리수
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        OneTwoThreeNumberOfCountries T = new OneTwoThreeNumberOfCountries();
        System.out.println(T.solution(1));
        System.out.println(T.solution(2));
        System.out.println(T.solution(3));
        System.out.println(T.solution(4));
    }
}
