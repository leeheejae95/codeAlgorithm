package programers.code.codingtestproblem.lv2;

public class NumberOfServerExpansions {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        for(int i=0;i<=23;i++) {
            int current = 0;
            int need = players[i]/m;
            for(int j=Math.max(0,i-k+1);j<=i;j++) {
                current += servers[j];
            }
            if(need > current) {
                int add = need-current;
                servers[i] = add;
                answer+=add;
            }
        }

       return answer;
    }

    public static void main(String[] args) {
        NumberOfServerExpansions T = new NumberOfServerExpansions();
        System.out.println(T.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},3,5));
        System.out.println(T.solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},5,1));
        System.out.println(T.solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},1,1));
    }
}
