package programers.code.codingtestproblem.lv2.practice;

public class StringCompressionPractice {

    public int solution(String s) {
        int answer = s.length();

        for(int len=1;len<=s.length()/2;len++) {
            StringBuilder sb = new StringBuilder(); // 압축문자열 append해줄 용도
            String prev = s.substring(0,len); // 이전문자열
            int cnt = 1;

            for(int i=len;i<s.length();i+=len) {
                int end = Math.min(i+len, s.length());
                String curr = s.substring(i, end);

                if(prev.equals(curr)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    sb.append(prev);
                    prev = curr;
                }
            }

            if(cnt > 1) sb.append(cnt);
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        StringCompressionPractice T = new StringCompressionPractice();
        System.out.println(T.solution("aabbaccc"));
        System.out.println(T.solution("ababcdcdababcdcd"));
        System.out.println(T.solution("abcabcdede"));
        System.out.println(T.solution("abcabcabcabcdededededede")); // 24
        System.out.println(T.solution("xababcdcdababcdcd"));
    }
}
