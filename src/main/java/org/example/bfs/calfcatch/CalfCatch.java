package org.example.bfs.calfcatch;

import java.util.*;

public class CalfCatch {
    public int solution(int s, int e){
        int answer = 0;
        int[][] ch = new int[2][200001]; // 현수가 짝수초 레벨에 도착체크 / 홀수초 레벨에 도착체크
        Queue<Integer> queue = new LinkedList<>();
        ch[0][s] = 1; // 0레벨 부터 시작 ( 짝수초 체크 )
        queue.offer(s);
        int L=0; // 몇초인지
        while(!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for(int i=0; i<len; i++) {
                int x = queue.poll();
                for(int nx : new int[]{x-1,x+1,x*2}) {
                    if(nx>=0 && nx<=200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            e = e + L; // L초에 송아지 위치
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return L;
        }

        return -1;
    }

    public static void main(String[] args){
        CalfCatch T = new CalfCatch();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
        System.out.println(T.solution(50, 51));
        System.out.println(T.solution(3, 10));
        System.out.println(T.solution(2, 11));
    }
}
