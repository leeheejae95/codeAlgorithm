package edu.code.second_st;

import java.util.*;

public class DeliveryMenu {

    public boolean solution(String[] menus, String[] orders) {
        HashSet<String> set = new HashSet<>();
        for(String x : menus) {
            set.add(x);
        }
        for(String x : orders) {
            if(!set.contains(x)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DeliveryMenu T = new DeliveryMenu();
        String[] menus = {"떡볶이", "만두", "오뎅", "사이다", "콜라"};
        String[] orders = {"오뎅", "콜라", "만두"};

        System.out.println(T.solution(menus, orders));
    }
}
