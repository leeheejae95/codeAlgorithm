package programers.code.codingtestproblem.lv2;

import java.util.*;

public class HIndex {

    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i=0;i< citations.length;i++) {
            int h = n - i;
            if(citations[i] >= h) return h; // 6 >= 5
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex T= new HIndex();
        System.out.println(T.solution(new int[]{3, 0, 6, 1, 5}));
    }
}
