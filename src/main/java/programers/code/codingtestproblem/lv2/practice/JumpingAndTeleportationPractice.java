package programers.code.codingtestproblem.lv2.practice;

public class JumpingAndTeleportationPractice {

    public int solution(int n) {
        int answer = 0;
        while(n > 0) {
            if(n % 2==1) {
                n--;
                answer++;
            } else {
                n = n/2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        JumpingAndTeleportationPractice T = new JumpingAndTeleportationPractice();
        System.out.println(T.solution(5));
        System.out.println(T.solution(6));
        System.out.println(T.solution(5000));
    }
}
