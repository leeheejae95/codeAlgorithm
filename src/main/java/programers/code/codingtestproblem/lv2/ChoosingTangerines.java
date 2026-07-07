package programers.code.codingtestproblem.lv2;

import java.util.*;

public class ChoosingTangerines {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : tangerine) map.put(x, map.getOrDefault(x,0)+1);
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b-a); // 내림차순 2 2 2 1 1

        for(int x : list) {
            sum += x; // 0+2 -> 2+2 -> 4+2
            answer++; // 1 -> 2 -> 3
            if(sum >= k) break; // 2 -> 4 -> 6
        }

        return answer;
    }

    public static void main(String[] args) {
        ChoosingTangerines T = new ChoosingTangerines();
        System.out.println(T.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
