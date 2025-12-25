package edu.code.third_st.hash;

import java.util.*;

public class AttendanceCheck {
    public ArrayList<String> solution(String[] allNames, String[] presentName) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : allNames) map.put(name, map.getOrDefault(name, 0) + 1);
        for(String name: presentName) map.put(name, map.getOrDefault(name, 0) - 1);
        for(String key: map.keySet()) {
            if(map.get(key) > 0) res.add(key);
        }

        return res;
    }
    public static void main(String[] args) {
        AttendanceCheck T = new AttendanceCheck();

        printArray(T.solution(new String[]{"나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"}, new String[]{"정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현"}));
        printArray(T.solution(new String[]{"류진","예지","채령","리아","유나"}, new String[]{"리아","류진","채령","유나"}));
        printArray(T.solution(new String[]{"정국","진","뷔","슈가","지민","RM"}, new String[]{"뷔","정국","지민","진","슈가"}));
    }

    public static void printArray(ArrayList<String> arr) {
        System.out.print("[");
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i));
            if(i < arr.size()-1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
