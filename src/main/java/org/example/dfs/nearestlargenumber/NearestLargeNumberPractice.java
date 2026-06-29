package org.example.dfs.nearestlargenumber;

import java.util.*;

public class NearestLargeNumberPractice {
    int answer,target,len;
    ArrayList<Integer> list;
    int[] ch;
    boolean flag; // n보다 큰수중 가장 작은수 구분

    public void DFS(int L, int num) {
        if(flag) return;
        if(L == len) {
            if(num > target) {
                answer = num;
                flag = true;
            }
        } else {
            for(int i=0;i<len;i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L+1, num*10+list.get(i)); // 1 -> 12 -> 123 .....
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n){
        answer = 0;
        list = new ArrayList<>();
        flag = false;
        target = n;
        int tmp = n;
        while(tmp > 0) {
            int num = tmp%10; // 123 -> 3 / 12 -> 2 / 1 -> 1
            list.add(num); // 3 2 1
            tmp = tmp/10;
        }
        list.sort((a, b) -> a-b); // 1,2,3
        len = list.size();
        ch = new int[len];
        DFS(0,0);
        if(flag == false) return -1;

        return answer;
    }

    public static void main(String[] args){
        NearestLargeNumberPractice T = new NearestLargeNumberPractice();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
