package edu.code.one_st;

import java.util.*;

public class Code {
    // 0 에서 1을 마주쳤을 때 뒤집는다 -> 전체를 0으로 만들기 위한 작업
    // 1 에서 0을 마주쳤을 때 뒤집는다 -> 전체를 1로 만들기 위한 작업

    public static int findCountToTurnOutToAllZeroOrAllOne(String string) {
        int countToAllZero = 0;
        int countToAllOne = 0;
        if (string.charAt(0) == '0') {
            countToAllOne += 1;
        } else if (string.charAt(0) == '1') {
            countToAllZero += 1;
        }

        for (int i = 0; i < string.length() - 1; i++) { // i 0부터 문자열의 길이 - 2 까지가 됩니다.
            if (string.charAt(i) != string.charAt(i + 1)) {
                if (string.charAt(i + 1) == '1') {
                    countToAllZero += 1;
                }
                if (string.charAt(i + 1) == '0') {
                    countToAllOne += 1;
                }
            }
        }
        return Math.min(countToAllZero, countToAllOne);
    }

    public static void main(String[] args) {
        String input = "011110";
        int result = findCountToTurnOutToAllZeroOrAllOne(input);
        System.out.println(result);
    }
}
