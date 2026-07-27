package programers.code.codingtestproblem.lv2;

import java.util.*;

public class NewsClustering {

    public int solution(String str1, String str2) {
//        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> list1 = letterCheck1(str1);
        ArrayList<String> list2 = letterCheck2(str2);

        if(list1.isEmpty() && list2.isEmpty()) return 65536; // 둘다 교집합일 경우

        int answer = comUniCnt(list1, list2);

        return answer;
    }

    public ArrayList<String> letterCheck1(String str1) {
        ArrayList<String> list1 = new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++) {
            String text1 = str1.substring(i,i+2);
            if(Character.isLetter(text1.charAt(0)) && Character.isLetter(text1.charAt(1))) list1.add(text1); // 문자만 필터
        }
        return list1;
    }

    public ArrayList<String> letterCheck2(String str2) {
        ArrayList<String> list2 = new ArrayList<>();
        for(int i=0;i<str2.length()-1;i++) {
            String text2 = str2.substring(i,i+2);
            if(Character.isLetter(text2.charAt(0)) && Character.isLetter(text2.charAt(1))) list2.add(text2); // 문자만 필터
        }
        return list2;
    }

    public int comUniCnt(ArrayList<String> list1, ArrayList<String> list2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        for(String s : list1) map1.put(s, map1.getOrDefault(s,0)+1); // FR:1, RA:1, AN:1, NC:1, CE:1
        for(String s : list2) map2.put(s, map2.getOrDefault(s,0)+1); // FR:1, RE:1, EN:1, NC:1, CH:1

        int common = 0;
        int union = 0;
        HashSet<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        System.out.println(set);
        for(String key : set) { // CE, RE, NC, CH, EN, FR, AN, RA
            int com = map1.getOrDefault(key,0);
            int uni = map2.getOrDefault(key,0);

            common += Math.min(com, uni);
            union += Math.max(com, uni);
        }

        return (int)(65536 * ((double)common / union));
    }

    public static void main(String[] args) {
        NewsClustering T = new NewsClustering();
        System.out.println(T.solution("FRANCE", "french"));
        System.out.println(T.solution("handshake", "shake hands"));
        System.out.println(T.solution("aa1+aa2", "AAAA12"));
        System.out.println(T.solution("E=M*C^2", "e=m*c^2"));
    }
}
