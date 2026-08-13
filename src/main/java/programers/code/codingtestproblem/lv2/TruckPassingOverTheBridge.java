package programers.code.codingtestproblem.lv2;

import java.util.*;

public class TruckPassingOverTheBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0;i< bridge_length;i++) bridge.offer(0);
        int idx = 0;
        int bridgeWeight = 0;
        while(idx<truck_weights.length) {
            bridgeWeight -= bridge.poll();
            if(bridgeWeight+truck_weights[idx]<=weight) {
                bridge.offer(truck_weights[idx]);
                bridgeWeight += truck_weights[idx++];
            } else {
                bridge.offer(0);
            }
            answer++; // 5
        }
        answer += bridge_length;

        return answer;
    }

    public static void main(String[] args) {
        TruckPassingOverTheBridge T = new TruckPassingOverTheBridge();
        System.out.println(T.solution(2,10,new int[]{7,4,5,6}));
        System.out.println(T.solution(100,100,new int[]{10}));
        System.out.println(T.solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
