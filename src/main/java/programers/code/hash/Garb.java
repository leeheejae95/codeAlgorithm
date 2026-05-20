package programers.code.hash;

import java.util.*;

public class Garb {

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type,0)+1);
        }

        for(int cnt : map.values()) { // 키에 해당하는 값만 가져오기
            answer *= (cnt+1);
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Garb T = new Garb();

        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(T.solution(clothes1));

        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(T.solution(clothes2));
    }
}
