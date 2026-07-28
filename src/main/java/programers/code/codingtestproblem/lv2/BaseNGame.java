package programers.code.codingtestproblem.lv2;

public class BaseNGame {

    public String solution(int n, int t, int m, int p) { // 2 4 2 1
//        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        // 2진수로
        while(sb.length()<t*m) sb.append(Integer.toString(num++,n).toUpperCase());

        StringBuilder answer = new StringBuilder();
        for(int i=p-1;answer.length()<t;i+=m) {
            answer.append(sb.charAt(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        BaseNGame T = new BaseNGame();
        System.out.println(T.solution(2,4,2,1));
        System.out.println(T.solution(16,16,2,1));
        System.out.println(T.solution(16,16,2,2));
    }
}
