package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class MenuRenewalPractice {

    HashMap<String, Integer> map;

    public void DFS(String order, int from, int len, String cur) {
        if(cur.length() == len) {
            map.put(cur, map.getOrDefault(cur,0)+1);
            return;
        } else {
            for(int i=from;i<order.length();i++) {
                DFS(order, i+1, len, cur+order.charAt(i));
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
//        String[] answer = {};
        map = new HashMap<>();
        for(String order : orders) {
            char[] food = order.toCharArray();
            Arrays.sort(food);
            String sorted = new String(food);
            for(int len : course) DFS(sorted, 0, len, "");
        }

        System.out.println(map);
        ArrayList<String> foodList = new ArrayList<>();
        for(int x : course) {
            int max = Integer.MIN_VALUE;
            for(Map.Entry<String, Integer> food : map.entrySet()) if(food.getKey().length() == x) max = Math.max(max, food.getValue());

            if(max>=2) {
                for(Map.Entry<String, Integer> foodInfo : map.entrySet()) {
                    if(foodInfo.getKey().length()==x && foodInfo.getValue()==max) {
                        foodList.add(foodInfo.getKey());
                    }
                }
            }
        }

        Collections.sort(foodList);
        String[] answer = new String[foodList.size()];
        for(int i=0;i< foodList.size();i++) answer[i] = foodList.get(i);


        return answer;
    }

    public static void main(String[] args) {
        MenuRenewalPractice T = new MenuRenewalPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
        System.out.println(Arrays.toString(T.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5})));
        System.out.println(Arrays.toString(T.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4})));
    }
}
