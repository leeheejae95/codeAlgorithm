package programers.code.codingtestproblem.lv2;

public class JumpingAndTeleportation {

    public int solution(int n) {
        int answer = 0;
        while(n > 0) {
            if(n % 2 == 1) { // 점프
                n--; // 점프할 경우 건전지 소모
                answer++;
            } else { // 순간이동
                n = n / 2; // 순간이동은 건전지 소모가 없음
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        JumpingAndTeleportation T = new JumpingAndTeleportation();
        System.out.println(T.solution(5));
        System.out.println(T.solution(6));
        System.out.println(T.solution(5000));
    }
}
