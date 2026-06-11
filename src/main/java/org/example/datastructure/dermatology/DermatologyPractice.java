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
        int[][] infoList = new int[n][2];
        for(int i=0;i<n;i++) {
            int arrive = getTime(enter[i].split(" ")[0]);
            int laserType = Integer.parseInt(enter[i].split(" ")[1]);

            infoList[i][0] = arrive;
            infoList[i][1] = laserType;
        }

        Queue<Integer> Q = new LinkedList<>();
        // 첫번째 손님은 기다리지 않고 시술실 들어감
        Q.add(infoList[0][1]);
        int fT = infoList[0][0];
        int pos = 1;
        for(int time=fT; time<=1200;time++) {

            if(pos<n && time==infoList[pos][0]) {
                if(Q.isEmpty() && infoList[pos][0]>fT) fT = infoList[pos][0]; // 도착시간이 fT가 클경우 업데이트 해줘야됨
                Q.add(infoList[pos][1]);
                pos++;
            }
            if(!Q.isEmpty() && fT==time) {
                int laserTypeExit = Q.poll(); // 0
                fT += laser[laserTypeExit]; // 623 + 30 = 653
            }
            answer = Math.max(answer,Q.size());
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
