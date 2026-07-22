package programers.code.codingtestproblem.lv2;

import java.util.*;

public class RollCakeCutting {

    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int rightNum : topping) map.put(rightNum, map.getOrDefault(rightNum,0)+1);
        for(int i=0;i< topping.length;i++) {
            set.add(topping[i]);
            map.put(topping[i],map.getOrDefault(topping[i],0)-1);
            if(map.getOrDefault(topping[i],0) == 0) map.remove(topping[i]);
            if(set.size() == map.size()) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        RollCakeCutting T = new RollCakeCutting();
        System.out.println(T.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(T.solution(new int[]{1, 2, 3, 1, 4}));
    }
}
