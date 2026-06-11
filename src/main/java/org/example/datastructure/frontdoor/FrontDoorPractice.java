package org.example.datastructure.frontdoor;

import java.util.*;

public class FrontDoorPractice {
    public int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
//        int[] answer = {};
        int[] answer = new int[n];
        PriorityQueue<Integer> enterQ = new PriorityQueue<>();
        PriorityQueue<Integer> exitQ = new PriorityQueue<>();
        int prev = 1; // 나가는 사람이 먼저
        int time = 0;
        int idx = 0;
        while(idx < n ||!enterQ.isEmpty() || !exitQ.isEmpty()) {

            while(idx<n && arrival[idx]==time) {
                if(state[idx] == 0) enterQ.add(idx);
                else exitQ.add(idx);
                idx++;
            }

            if(enterQ.isEmpty() && exitQ.isEmpty()) {
                time = arrival[idx];
                prev = 1;
                continue; // 시간 놓치기 방지
            }

            if(!exitQ.isEmpty() && prev == 1) {
                answer[exitQ.poll()] = time;
                prev = 1;
            } else if(!exitQ.isEmpty() && enterQ.isEmpty()) {
                answer[exitQ.poll()] = time;
                prev = 1;
            } else if(!enterQ.isEmpty() && prev == 0) {
                answer[enterQ.poll()] = time;
                prev = 0;
            } else if(!enterQ.isEmpty() && exitQ.isEmpty()) {
                answer[enterQ.poll()] = time;
                prev = 0;
            } else {
                answer[enterQ.poll()] = time;
                prev = 0;
            }

            time++;
        }

        return answer;
    }

    public static void main(String[] args){
        FrontDoorPractice T = new FrontDoorPractice();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}

