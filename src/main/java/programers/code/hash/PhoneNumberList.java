package programers.code.hash;

import java.util.*;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String number : phone_book) map.put(number, map.getOrDefault(number, 0) + 1);

        for(String phone : phone_book) { // "119", "97674223", "1195524421"
            for(int i=1; i < phone.length(); i++) { // 1195524421
                String phoneStr = phone.substring(0,i); // 1 / 11 / 119 / ....
                if(map.containsKey(phoneStr)) { // 맵에 키값이랑 동일한게 있는지 확인
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PhoneNumberList T = new PhoneNumberList();

        String[] str1 = {"119", "97674223", "1195524421"};
        System.out.println(T.solution(str1));

        String[] str2 = {"123","456","789"};
        System.out.println(T.solution(str2));

        String[] str3 = {"12","123","1235","567","88"};
        System.out.println(T.solution(str3));
    }
}
