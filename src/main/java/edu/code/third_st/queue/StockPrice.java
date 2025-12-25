package edu.code.third_st.queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) { // O(N)
            int priceNotFallPeriod = 0;
            for (int j = i + 1; j < prices.length; j++) { // O(N)
                if (prices[i] <= prices[j]) {
                    priceNotFallPeriod++;
                } else {
                    priceNotFallPeriod++;
                    break;
                }
            }
            answer[i] = priceNotFallPeriod;
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice T = new StockPrice();
        printArray(T.solution(new int[]{1,2,3,2,3}));
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
