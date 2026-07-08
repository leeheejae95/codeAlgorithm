package programers.code.codingtestproblem.lv2;

import java.util.*;

public class LifeBoat {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length-1;
        while(lt <= rt) { // 0 <= 3
            if(people[lt] + people[rt] <= limit) { // 50 50 70 80
                lt++;
                rt--;
                answer++;
            } else {
                rt--;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LifeBoat T = new LifeBoat();
        System.out.println(T.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(T.solution(new int[]{70, 80, 50}, 100));
    }
}
