package programers.code.codingtestproblem.lv2;

import java.util.*;

public class MenuRenewal {
    HashMap<String,Integer> map;
    public void DFS(String order, int start, int len, String curr) {
        if(curr.length()==len) {
            map.put(curr,map.getOrDefault(curr,0)+1);
            return;
        }
        for(int i=start; i<order.length(); i++) {  // start부터
            DFS(order, i+1, len, curr+order.charAt(i));
        }
    }

    public String[] solution(String[] orders, int[] course) {
//        String[] answer = {};
        map = new HashMap<>();

        for(String order : orders) {
            char[] food = order.toCharArray();
            Arrays.sort(food); // 다른 조합으로 인식 방지 ( 사전순으로 정리 )
            String sorted = new String(food); // ABCFG

            for(int len : course) {
                DFS(sorted,0,len,"");
            }
        }

        ArrayList<String> foodList = new ArrayList<>();
        for(int x : course) {
            int max = Integer.MIN_VALUE;
            for(Map.Entry<String,Integer> info : map.entrySet()) {
                if(info.getKey().length()==x) {
                    max = Math.max(max, info.getValue());
                }
            }
            if(max>=2) { // 최소 2가지 이상
                for(Map.Entry<String,Integer> foodInfo : map.entrySet()) {
                    if(foodInfo.getKey().length()==x && foodInfo.getValue()==max) {
                        foodList.add(foodInfo.getKey());
                    }
                }
            }
        }

        Collections.sort(foodList);
        String[] answer = new String[foodList.size()];
        for(int i=0;i<foodList.size();i++) answer[i] = foodList.get(i);

        return answer;
    }

    public static void main(String[] args) {
        MenuRenewal T = new MenuRenewal();
        System.out.println(Arrays.toString(T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
        System.out.println(Arrays.toString(T.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5})));
        System.out.println(Arrays.toString(T.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4})));
    }
}
