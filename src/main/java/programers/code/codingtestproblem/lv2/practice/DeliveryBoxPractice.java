package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class DeliveryBoxPractice {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> sub = new Stack<>();
        Queue<Integer> belt = new LinkedList<>();
        for(int i=0;i< order.length;i++) {
            sub.push(i+1);
            while(!sub.isEmpty()) {
                if(sub.peek()==order[idx]) {
                    belt.offer(sub.pop());
                    idx++;
                } else {
                    break;
                }
            }
        }

        answer = belt.size();

        return answer;
    }


    public static void main(String[] args) {
        DeliveryBoxPractice T = new DeliveryBoxPractice();
        System.out.println(T.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(T.solution(new int[]{5, 4, 3, 2, 1}));
    }
}
