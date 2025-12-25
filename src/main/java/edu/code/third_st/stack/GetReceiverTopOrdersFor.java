package edu.code.third_st.stack;

public class GetReceiverTopOrdersFor {
    public int[] solution(int[] heights) {
        int n = heights.length;
        int[] answer = new int[heights.length];
        for(int i=n-1; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(heights[i] <= heights[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        GetReceiverTopOrdersFor T = new GetReceiverTopOrdersFor();

        int[] top_heights = {6, 9, 5, 7, 4};

        printArray(T.solution(top_heights));  // [0, 0, 2, 2, 4] 가 반환되어야 한다!

        System.out.print("정답 = [0, 0, 2, 2, 4] / 현재 풀이 값 = ");
        printArray(T.solution(new int[]{6, 9, 5, 7, 4}));

        System.out.print("정답 = [0, 0, 2, 3, 3, 3, 6] / 현재 풀이 값 = ");
        printArray(T.solution(new int[]{3, 9, 9, 3, 5, 7, 2}));

        System.out.print("정답 = [0, 0, 2, 0, 0, 5, 6] / 현재 풀이 값 = ");
        printArray(T.solution(new int[]{1, 5, 3, 6, 7, 6, 5}));
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i=0; i< array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
