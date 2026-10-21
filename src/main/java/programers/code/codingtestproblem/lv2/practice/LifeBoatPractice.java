package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class LifeBoatPractice {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length-1;
        while(lt<=rt) {
            if(people[lt] + people[rt] <= limit) {
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
        LifeBoatPractice T = new LifeBoatPractice();
        System.out.println(T.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(T.solution(new int[]{70, 80, 50}, 100));
    }
}