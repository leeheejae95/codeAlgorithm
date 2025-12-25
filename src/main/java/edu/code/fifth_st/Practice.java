package edu.code.fifth_st;

public class Practice {

    public static int solution(String str) {
        int answer = Integer.MAX_VALUE;
        int n = str.length();
        for(int i=1; i<=n/2; i++) {
            String prev = str.substring(0, i);
            int len = 0;
            int cnt = 1;
            int pos = i;
            while(pos + i <= n) {
                String cur = str.substring(pos, pos+i);
                if(cur.equals(prev)) {
                    cnt++;
                } else {
                    len += (cnt==1 ? 0 : String.valueOf(cnt).length()) + prev.length();
                    prev = cur;
                    cnt = 1;
                }
                pos += i;
            }
            len += (cnt==1 ? 0 : String.valueOf(cnt).length()) + prev.length();
            len += n - pos;
            answer = Math.min(answer, len);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 3 / 현재 풀이 값 = " + solution("JAAA"));
        System.out.println("정답 = 9 / 현재 풀이 값 = " + solution("AZAAAZDWAAA"));
        System.out.println("정답 = 12 / 현재 풀이 값 = " + solution("BBAABAAADABBBD"));
    }
}
