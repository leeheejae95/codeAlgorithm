package edu.code.fourth_st.dp;

import java.util.*;

class FiboDynamicProgramming {
    private static int input = 100;

    private static Map<Integer, Long> memo = new HashMap<>();

    static {
        memo.put(1, 1L);
        memo.put(2, 1L);
    }

    // 1. 메모에 이미 해당 값이 있으면 반환한다.
    // 2. 만약 없다면, 그 값을 피보나치를 통해 구하고 메모에 저장한다.
    public static long fiboDynamicProgramming(int n, Map<Integer, Long> fiboMemo) {
        if (fiboMemo.containsKey(n)) {
            return fiboMemo.get(n);
        }

        long nthFibo = fiboDynamicProgramming(n - 1, fiboMemo) + fiboDynamicProgramming(n - 2, fiboMemo);
        fiboMemo.put(n, nthFibo);

        return nthFibo;
    }

    public static void main(String[] args) {
        System.out.println(fiboDynamicProgramming(input, memo));
    }
}
