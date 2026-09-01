package programers.code.codingtestproblem.lv2;

import java.util.PriorityQueue;

public class DefenseGame {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int i=0;i<enemy.length;i++) {
            n-=enemy[i]; // 병사 소모
            pq.offer(enemy[i]);
            if(n < 0) { // 가장 큰 적에게 무적권 사용
                n+=pq.poll(); // 무적권 사용으로 복구
                k--;
            }
            if(k < 0) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        DefenseGame T = new DefenseGame();
        System.out.println(T.solution(7,3,new int[]{4,2,4,5,3,3,1}));
        System.out.println(T.solution(2,4,new int[]{3,3,3,3}));

    }
}
