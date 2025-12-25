package edu.code.third_st.queue;

import java.util.LinkedList;

import java.util.*;

public class StockPriceQueue {
    public ArrayList<Integer> solution(int[] price) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        for(int x : price) {
            Q.offer(x);
        }
        while(!Q.isEmpty()) {
            int cnt = 0;
            int curPrice = Q.poll(); // 1
            Queue<Integer> tmpQ = new LinkedList<>(Q); // 2 3 2 3
            for(int newPrice : tmpQ) {
                if(curPrice <= newPrice) {
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
            answer.add(cnt);
;        }

        return answer;
    }

    public static void main(String[] args) {
        StockPriceQueue T = new StockPriceQueue();
        printArray(T.solution(new int[]{1,2,3,2,3}));
//        printArray(T.solution(new int[]{3, 9, 9, 3, 5, 7, 2}));
//        printArray(T.solution(new int[]{1, 5, 3, 6, 7, 6, 5}));
    }

    public static void printArray(ArrayList<Integer> arr) {
        System.out.print("[");
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i));
            if(i < arr.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
