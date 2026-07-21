package programers.code.codingtestproblem.lv2;

import java.util.*;

public class DiscountEvent {

    public boolean check(HashMap<String,Integer> wantMap, HashMap<String,Integer> discountMap) {
        for(String type : wantMap.keySet()) {
            if(discountMap.getOrDefault(type,0) < wantMap.get(type)) {
                return false;
            }
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String,Integer> wantMap = new HashMap<>();
        for(int i=0;i<want.length;i++) wantMap.put(want[i], number[i]); // banana : 3 apple : 2 rice : 2 pork : 2 pot : 1

        HashMap<String,Integer> discountMap = new HashMap<>();
        for(int i=0;i<10;i++) discountMap.put(discount[i], discountMap.getOrDefault(discount[i],0)+1);

        for(int i=10;i<discount.length;i++) {
            String out = discount[i-10];
            discountMap.put(out, discountMap.getOrDefault(out,0)-1);
            String in = discount[i];
            discountMap.put(in, discountMap.getOrDefault(in,0)+1);
            if(check(wantMap, discountMap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        DiscountEvent T = new DiscountEvent();
        System.out.println(T.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(T.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }
}
