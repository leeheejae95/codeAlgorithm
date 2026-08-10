package programers.code.codingtestproblem.lv2.practice;

import java.util.Arrays;

public class SortByFileNamePractice {
    public String getHeader(String file) {
        String headText = "";
        for(char c : file.toCharArray()) {
            if(Character.isDigit(c)) break;
            headText += c;
        }

        return headText;
    }

    public String getNumber(String file) {
        String number = "";
        boolean flag = false;
        for(char c : file.toCharArray()) {
            if(Character.isDigit(c)) {
                number += c;
                flag = true;
            }
            else if(flag) break;
        }
        return number;
    }

    public String[] solution(String[] files) {
//        String[] answer = {};
        Arrays.sort(files,(a, b) ->{
            String headA = getHeader(a);
            String headB = getHeader(b);

            int compare = headA.toUpperCase().compareTo(headB.toUpperCase());
            if(compare != 0) return compare;

            return Integer.parseInt(getNumber(a))-Integer.parseInt(getNumber(b));
        });

        return files;
    }

    public static void main(String[] args) {
        SortByFileNamePractice T = new SortByFileNamePractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}
