package edu.code.third_st.problem;

import java.util.*;

public class Discount {
    public int solution(int[] product, int[] cupon) {
       Integer[] products = Arrays.stream(product).boxed().toArray(Integer[]::new);
       Integer[] cupons = Arrays.stream(cupon).boxed().toArray(Integer[]::new);
       Arrays.sort(products, Collections.reverseOrder());
       Arrays.sort(cupons, Collections.reverseOrder());

       int products_index = 0;
       int cupons_index = 0;
       int max_price = 0;
       while(products_index < products.length && cupons_index < cupons.length) {
           max_price += products[products_index] * (100 - cupons[cupons_index]) / 100;
           products_index++;
           cupons_index++;
       }
       while(products_index < products.length) {
           max_price += products[products_index];
           products_index++;
       }

        return max_price;
    }
    public static void main(String[] args) {
        Discount T = new Discount();
        System.out.println(T.solution(new int[]{30000, 2000, 1500000}, new int[]{20, 40}));
        System.out.println(T.solution(new int[]{50000, 1500000}, new int[]{10, 70, 30, 20}));
        System.out.println(T.solution(new int[]{50000, 1500000}, new int[]{}));
        System.out.println(T.solution(new int[]{20000, 100000, 1500000}, new int[]{10, 10, 10}));
    }
}