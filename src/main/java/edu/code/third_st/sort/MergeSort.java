package edu.code.third_st.sort;

import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 1, 6, 8, 7, 4};

        printArray(mergeSort(array));  // [1, 2, 3, 4, 5, 6, 7, 8] 가 되어야 합니다!

        System.out.print("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = ");
        printArray(mergeSort(new int[]{-7, -1, 9, 40, 5, 6, 10, 11}));

        System.out.print("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = ");
        printArray(mergeSort(new int[]{-1, 2, 3, 5, 40, 10, 78, 100}));

        System.out.print("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = ");
        printArray(mergeSort(new int[]{-1, -1, 0, 1, 6, 9, 10}));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(leftArray, rightArray);
    }

    // O(N)
    public static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int resultIndex = 0;
        int array1Index = 0;
        int array2Index = 0;

        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                result[resultIndex++] = array1[array1Index];
                array1Index++;
            } else {
                result[resultIndex++] = array2[array2Index];
                array2Index++;
            }
        }

        while (array1Index < array1.length) {
            result[resultIndex++] = array1[array1Index];
            array1Index++;
        }

        while (array2Index < array2.length) {
            result[resultIndex++] = array2[array2Index];
            array2Index++;
        }

        // 이 부분을 채워보세요!
        return result;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
