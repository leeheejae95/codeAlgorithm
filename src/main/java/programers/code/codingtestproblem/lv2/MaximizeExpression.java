package programers.code.codingtestproblem.lv2;

import java.util.ArrayList;

public class MaximizeExpression {

    long answer;
    ArrayList<Long> nums;
    ArrayList<Character> ops;
    char[] priority = {'*','-','+'};
    int[] ch;

    public long calc(long a, long b, char op) {
        if(op=='+') return a+b;
        if(op == '-') return a-b;
        return a*b;
    }

    public void DFS(int L, char[] val) {
        if(L==3) {
            ArrayList<Long> tmpNums = new ArrayList<>(nums);
            ArrayList<Character> tmpOps = new ArrayList<>(ops);

            for(char op : val) { // 연산자
                for(int i=0;i<tmpOps.size();i++) {
                    if(tmpOps.get(i) == op) {
                        long result = calc(tmpNums.get(i), tmpNums.get(i+1), op);
                        tmpNums.set(i, result);
                        tmpNums.remove(i+1);
                        tmpOps.remove(i);
                        i--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tmpNums.get(0)));
            return;
        } else {
            for(int i=0;i<3;i++) {
                if(ch[i]==0) {
                    ch[i] = 1;
                    val[L] = priority[i]; // 연산 넣기
                    DFS(L+1,val);
                    ch[i] = 0;
                }
            }
        }
    }

    public long solution(String expression) {
        answer = 0;
        nums = new ArrayList<>(); // 숫자담기
        ops = new ArrayList<>(); // 연산자 담기
        ch = new int[3]; // 체크배열
        String[] parts = expression.split("[+\\-*]");
        for(String s : parts) nums.add(Long.parseLong(s));
        for(char c : expression.toCharArray()) if(c=='*' || c=='+' || c=='-') ops.add(c);
        DFS(0,new char[3]);


        return answer;
    }

    public static void main(String[] args) {
        MaximizeExpression T = new MaximizeExpression();
        System.out.println(T.solution("100-200*300-500+20"));
        System.out.println(T.solution("50*6-3*2"));
    }
}
