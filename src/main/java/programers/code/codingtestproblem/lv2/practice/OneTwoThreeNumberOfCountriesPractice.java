package programers.code.codingtestproblem.lv2.practice;

public class OneTwoThreeNumberOfCountriesPractice {

    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        while(n>0) {
            int a = n % 3; // 나머지
            if(a==0) {
                sb.append(4);
                n=n/3-1; // while문 종료
            } else {
                sb.append(a);
                n=n/3; // 다음 자릿수
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        OneTwoThreeNumberOfCountriesPractice T = new OneTwoThreeNumberOfCountriesPractice();
        System.out.println(T.solution(1));
        System.out.println(T.solution(2));
        System.out.println(T.solution(3));
        System.out.println(T.solution(4));
    }
}
