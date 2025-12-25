package edu.code.fourth_st.practice;

import java.util.*;

public class Cgv {
    private static int seatCount = 9;
    private static int[] vipSeatArray = {4,7};
    public static HashMap<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1,1);
        map.put(2,2);
    }
    // 1. 메모에 이미 해당 값이 있으면 반환한다.
    // 2. 만약 없다면, 그 값을 피보나치를 통해 구하고 메모에 저장한다.
    public static int fiboDynamicProgramming(int n, HashMap<Integer, Integer> fiboMemo) {
        if(fiboMemo.containsKey(n)) {
            return fiboMemo.get(n);
        }

        int fibo = fiboDynamicProgramming(n-1, fiboMemo) + fiboDynamicProgramming(n-2, fiboMemo);
        fiboMemo.put(n, fibo);
        return fibo;
    }
    public int solution(int n, int[] vip){
        int answer = 1;
        int cur_index = 0;
        for(int x : vip) {
            int fixed_seat_index = x-1;
            int cnt = fiboDynamicProgramming(fixed_seat_index-cur_index, map);
            answer *= cnt;
            cur_index = fixed_seat_index + 1;
        }

        int countWay = fiboDynamicProgramming(n - cur_index, map);
        answer *= countWay;

        return answer;
    }

    public static void main(String[] args){
        Cgv T = new Cgv();
        System.out.println(T.solution(seatCount, vipSeatArray));
    }
}
