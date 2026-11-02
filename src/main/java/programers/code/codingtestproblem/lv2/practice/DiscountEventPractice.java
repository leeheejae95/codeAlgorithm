package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class DiscountEventPractice {

    // 원하는 품목마다 수량이 충분한지 확인하기
    public boolean check(HashMap<String,Integer> map, HashMap<String,Integer> window) {
        for(String key : map.keySet()) {
            if(window.getOrDefault(key,0) < map.get(key)) {
                return false;
            }
        }

        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = want.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<len;i++) map.put(want[i], number[i]); // 내가 원하는 품목수

        HashMap<String,Integer> window = new HashMap<>();
        for(int i=0;i<10;i++) window.put(discount[i], window.getOrDefault(discount[i],0)+1); // 10일 구간에 실제로 할인하는 품목과 수량
        if(check(map, window)) answer++;

        for(int i=10;i<discount.length;i++) {
            String out = discount[i-10]; // chicken : -1
            window.put(out, window.get(out)-1); // out에 해당하는 종류 -1

            String in = discount[i]; // pot : +1
            window.put(in, window.getOrDefault(in,0)+1); // in에 해당하는 종류 +1

            if(check(map,window)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        DiscountEventPractice T = new DiscountEventPractice();
        System.out.println(T.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(T.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }
}
