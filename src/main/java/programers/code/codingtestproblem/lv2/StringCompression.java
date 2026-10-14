package programers.code.codingtestproblem.lv2;

public class StringCompression {

    public int solution(String s) {
        int answer = s.length(); // 8
        for(int len=1;len<=s.length()/2;len++) { // 4
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0,len); // 이전문자열 [a]
            int cnt = 1; // 자기자신 포함

            for(int i=len;i<s.length();i+=len) {
                int end = Math.min(i+len, s.length()); // (2,8) -> 2
                String curr = s.substring(i,end); // (1,2) : a 현재 문자열

                if(prev.equals(curr)) { // 이전문자열이랑 현재문자열이랑 같은면 cnt
                    cnt++; // 2
                } else {
                    if(cnt>1) {
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
        StringCompression T = new StringCompression();
        System.out.println(T.solution("aabbaccc"));
        System.out.println(T.solution("ababcdcdababcdcd"));
        System.out.println(T.solution("abcabcdede"));
        System.out.println(T.solution("abcabcabcabcdededededede"));
        System.out.println(T.solution("xababcdcdababcdcd"));
    }
}
