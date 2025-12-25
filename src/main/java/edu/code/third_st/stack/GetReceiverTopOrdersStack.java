package edu.code.third_st.stack;

import java.util.*;

public class GetReceiverTopOrdersStack {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int x : heights) stack.push(x);

        while(!stack.isEmpty()) {
            int height = stack.pop();
            int index = stack.size();
            for(int i=index-1; i>=0; i--) {
                if(height <= heights[i]) {
                    answer[index] = i+1; // 첫번째 탑, 두번째 탑... 이므로 +1을 해줘야 한다.
                    break; // 발견 되면 더 이상 반복할 필요 없음
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        GetReceiverTopOrdersStack T = new GetReceiverTopOrdersStack();

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
