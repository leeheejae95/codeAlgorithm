package org.example.simulation.meeting;

import java.util.*;

public class Meeting {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        for(int i=0; i<n; i++) {
            enter[i]--; // enter => 0 1 4 2 3
            exit[i]--; // exit => 1 2 0 3 4
        }
        int[] enterIdx = new int[n]; // 입장순서 인덱스
        for(int i=0; i<n; i++) {
            enterIdx[enter[i]] = i; // enter => 0 1 4 2 3에서 3번째는 값이 2이기 때문에 enterIdx[3]에 2가 들어감
        }
        int[] enterT = new int[n]; // 회의실 들어오는 시간
        int[] exitT = new int[n]; // 회의실 나가는 시간
        int cnt = 0; // 시간
        for(int i = 0, j = 0; i < n; i++){ // i번째 사람이 나가는 동시에 j번째 사람이 들어 와야됨
            while(j < n && j <= enterIdx[exit[i]]){
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(!(exitT[i] < enterT[j] || exitT[j] < enterT[i])){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Meeting T = new Meeting();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
