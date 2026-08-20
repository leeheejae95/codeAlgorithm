package programers.code.codingtestproblem.lv2;

import java.util.*;

public class SeesawPartner {

    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer,Long> map = new HashMap<>();

        for(int weight : weights) {
            if(map.containsKey(weight)) answer += map.get(weight);  // 1:1
            if(weight%3==0 && map.containsKey(weight*2/3)) answer += map.get(weight*2/3);  // 2:3
            if(weight%2==0 && map.containsKey(weight*3/2)) answer += map.get(weight*3/2);  // 3:2
            if(weight%4==0 && map.containsKey(weight*2/4)) answer += map.get(weight*2/4);  // 2:4
            if(map.containsKey(weight*2)) answer += map.get(weight*2);  // 4:2
            if(weight%4==0 && map.containsKey(weight*3/4)) answer += map.get(weight*3/4);  // 3:4
            if(weight%3==0 && map.containsKey(weight*4/3)) answer += map.get(weight*4/3);  // 4:3
            map.put(weight,map.getOrDefault(weight,0L)+1);
        }


        return answer;
    }

    public static void main(String[] args) {
        SeesawPartner T = new SeesawPartner();
        System.out.println(T.solution(new int[]{100,180,360,100,270}));
    }
}
