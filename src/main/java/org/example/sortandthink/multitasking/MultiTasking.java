package org.example.sortandthink.multitasking;

import java.util.*;

public class MultiTasking {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int[] sT = new int[tasks.length + 1]; // 작업시간
        // System.arraycopy(원본배열, 원본시작위치, 대상배열, 대상시작위치, 복사할개수);
        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);
        int rest = tasks.length; // 작업 개수
        for(int i = 1; i < sT.length; i++){
            long time = ((long)rest * (sT[i] - sT[i-1]));
            if(k < time){
                long idx = k % rest; // 살아있는 작업중 몇번째 작업에서 멈췄는지
                int cnt = 0;
                for(int j = 0; j < tasks.length; j++){
                    if(tasks[j] >= sT[i]){ // 현재 층(sT[i])까지 깎였다고 가정 했을때 이 작업이 살아 있는지 확인
                        // cnt가 0일때 k는 1초실행.... cnt가 2일때 정전이 되고 cnt가 3일때 다시 처리하는 작업번호 반환
                        if(cnt == idx) return j+1;
                        cnt++;
                    }
                }
            }
            else{
                k -= time;
                rest--;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MultiTasking T = new MultiTasking();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
