package edu.code.third_st.sort;

import java.util.*;

public class Merge {
    public ArrayList<Integer> solution(int[] arr, int[] brr) {
        ArrayList<Integer> res = new ArrayList<>();
        int lt = 0;
        int rt = 0;
        while(lt < arr.length && rt < brr.length) {
            if(arr[lt] < brr[rt]) {
                res.add(arr[lt]);
                lt++;
            } else {
                res.add(brr[rt]);
                rt++;
            }
        }
        while(lt < arr.length) {
            res.add(arr[lt]);
            lt++;
        }
        while(rt < brr.length) {
            res.add(brr[rt]);
            rt++;
        }

        return res;
    }
    public static void main(String[] args) {
        Merge T = new Merge();
        System.out.println(T.solution(new int[]{1, 2, 3, 5}, new int[]{4, 6, 7, 8}));
        System.out.println(T.solution(new int[]{-7, -1, 9, 40}, new int[]{5, 6, 10, 11}));
        System.out.println(T.solution(new int[]{-1,2,3,5,40}, new int[]{10,78,100}));
        System.out.println(T.solution(new int[]{-1,-1,0}, new int[]{1, 6, 9, 10}));
    }
}
