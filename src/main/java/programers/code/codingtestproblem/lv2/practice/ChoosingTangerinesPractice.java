package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class ChoosingTangerinesPractice {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : tangerine) map.put(x, map.getOrDefault(x,0)+1);

        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b-a);

        for(int x : list) {
            sum += x;
            answer++;
            if(sum>=k) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        ChoosingTangerinesPractice T = new ChoosingTangerinesPractice();
        System.out.println(T.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
