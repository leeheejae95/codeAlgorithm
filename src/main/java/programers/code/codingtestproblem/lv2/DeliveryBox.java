package programers.code.codingtestproblem.lv2;

import java.util.*;

public class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;
        Stack<Integer> sub = new Stack<>(); // 보조
        Queue<Integer> truck = new LinkedList<>(); // 트럭
        for(int i=0;i<order.length;i++) {
            sub.push(i+1); // 보조에 넣기
            while(!sub.isEmpty()) {
                if(sub.peek() == order[cnt]) { // 택배기사가 알려준 순서와 영재가 보관한 순서
                    truck.offer(sub.pop());
                    cnt++;
                } else {
                    break;
                }
            }
        }

        answer = truck.size();

        return answer;
    }


    public static void main(String[] args) {
        DeliveryBox T = new DeliveryBox();
        System.out.println(T.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(T.solution(new int[]{5, 4, 3, 2, 1}));
    }
}
