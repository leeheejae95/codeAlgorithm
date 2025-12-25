package edu.code.third_st.queue;

import java.util.*;

public class StockPriceQueuePractice {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> st = new LinkedList<>(); // 인덱스 스택

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[i] < prices[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i - idx; // 떨어진 시점까지의 시간
            }
            st.push(i);
        }
        while (!st.isEmpty()) { // 끝까지 안 떨어진 애들
            int idx = st.pop();
            ans[idx] = (n - 1) - idx;
        }
        return ans;
    }

    public static void main(String[] args) {
        StockPriceQueuePractice T = new StockPriceQueuePractice();
        printArray(T.solution(new int[]{1,2,3,2,3}));
        printArray(T.solution(new int[]{3, 9, 9, 3, 5, 7, 2}));
        printArray(T.solution(new int[]{1, 5, 3, 6, 7, 6, 5}));
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
