package programers.code.codingtestproblem.lv2;

public class DistributingNumberCards {

    public int GCD(int a, int b) {
        if(b==0) return a;
        return GCD(b,a%b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int resultA = arrayA[0];
        int resultB = arrayB[0];
        for(int x : arrayA) resultA = GCD(resultA,x);
        for(int x : arrayB) resultB = GCD(resultB,x);


        // GCD 구하고 나서
        // resultA로 arrayB 하나라도 나눠지면 -> 0
        // resultB로 arrayA 하나라도 나눠지면 -> 0
        boolean canA = true;  // resultA로 arrayB 못 나누는지
        boolean canB = true;  // resultB로 arrayA 못 나누는지
        for(int x : arrayB) if(x % resultA == 0) { canA = false; break; } // 영희에서 나눴을때 나눠지는지
        for(int x : arrayA) if(x % resultB == 0) { canB = false; break; } // 철수에서 나눴을때 나눠지는지

        if(canA) answer = Math.max(answer, resultA);
        if(canB) answer = Math.max(answer, resultB);

        return answer;
    }

    public static void main(String[] args) {
        DistributingNumberCards T = new DistributingNumberCards();
        System.out.println(T.solution(new int[]{10,17}, new int[]{5,20}));
        System.out.println(T.solution(new int[]{10,20}, new int[]{5,17}));
        System.out.println(T.solution(new int[]{14,35,119}, new int[]{18,30,102}));
    }
}
