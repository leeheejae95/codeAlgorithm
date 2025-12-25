package org.example.datastructure.dermatology;

import java.util.*;

public class DermatologyPractice {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }

    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            int a = getTime(enter[i].split(" ")[0]); // 입장시간
            int b = Integer.parseInt(enter[i].split(" ")[1]); // 레이저실
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Q.offer(inList[0][1]);
        int fT = inList[0][0];
        int pos = 1;
        for(int t=fT; t<1200; t++) {
            if(pos < n && inList[pos][0] == t) {
                if(Q.isEmpty() && fT < inList[pos][0]) fT = inList[pos][0];
                Q.offer(inList[pos][1]);
                pos++;
            }
            if(t==fT && !Q.isEmpty()) {
                int idx = Q.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }

        return answer;
    }

    public static void main(String[] args){
        DermatologyPractice T = new DermatologyPractice();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
