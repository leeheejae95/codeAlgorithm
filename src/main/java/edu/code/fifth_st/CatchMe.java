package edu.code.fifth_st;

import java.util.*;

public class CatchMe {
    static int c = 11;
    static int b = 2;
    public static int catchMe(int conyLoc, int brownLoc) {
        int answer = 0;
        int[][] ch = new int[2][200001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(brownLoc);
        ch[0][brownLoc] = 1;
        int L = 0;
        while(!q.isEmpty()) {
            int len =  q.size();
            L++;
            for(int i=0; i<len; i++) {
                int x = q.poll();
                for(int nx : new int[]{x-1,x+1,x*2}) {
                    if(nx>=0 && nx<=200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            conyLoc = conyLoc + L;
            if(conyLoc > 200000) return -1;
            if(ch[L%2][conyLoc] == 1) return L;
        }

        return  -1;
    }
    public static void main(String[] args) {
        System.out.println(catchMe(c, b));  // 5가 나와야 합니다!

        System.out.println("정답 = 3 / 현재 풀이 값 = " + catchMe(10, 3));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + catchMe(51, 50));
    }
}
