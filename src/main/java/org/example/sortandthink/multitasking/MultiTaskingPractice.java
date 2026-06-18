package org.example.sortandthink.multitasking;

import java.util.*;

public class MultiTaskingPractice {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int rest = tasks.length;
        int[] tmp = new int[tasks.length+1];
        System.arraycopy(tasks,0,tmp,1,tasks.length);
        Arrays.sort(tmp);
        for(int i=1;i<tmp.length;i++) {
            long size = (long)rest*(tmp[i]-tmp[i-1]); // 살아있는 작업의 총 시간
            if(k < size) {
                long idx = k % rest;
                int cnt = 0;
                for(int j=0;j<tasks.length;j++) {
                    if(tasks[j] >= tmp[i]) {
                        if(cnt==idx) return j+1;
                        cnt++;
                    }
                }
            } else {
                k -= size;
                rest--;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        MultiTaskingPractice T = new MultiTaskingPractice();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
