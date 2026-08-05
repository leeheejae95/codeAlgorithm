package programers.code.codingtestproblem.lv2;

import java.util.*;

public class SortByFileName {

    public String getHead(String file) {
        String head = "";
        for(char c : file.toCharArray()) {
            if(Character.isDigit(c)) break;
            head += c;
        }
        return head;
    }

    public String getNumber(String file) {
        String number = "";
        boolean started = false;
        for(char c : file.toCharArray()) {
            if(Character.isDigit(c)) { // 숫자일 경우 숫자 연결하기
                started = true;
                number += c;
            } else if(started) break; // 문자일경우 break
        }
        return number;
    }

    public String[] solution(String[] files) {
//        String[] answer = {};
        Arrays.sort(files, (a,b) ->{
            String headA = getHead(a);
            String headB = getHead(b);

            int compare = headA.toUpperCase().compareTo(headB.toUpperCase());
            if(compare != 0) return compare;

            return Integer.parseInt(getNumber(a))-Integer.parseInt(getNumber(b));
        });

        return files;
    }

    public static void main(String[] args) {
        SortByFileName T = new SortByFileName();
        System.out.println(Arrays.toString(T.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
//        System.out.println(Arrays.toString(T.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}
