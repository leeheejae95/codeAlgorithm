package edu.code.second_st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Josephus {

    public static ArrayList<Integer> solution(int n, int m) {
        int answer = 0;
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            num.add(i);
        }
        int idx = 0;
        while(!num.isEmpty()) {
            idx = (idx + m -1) % num.size();
            list.add(num.remove(idx));
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ans = solution(n, m);

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i < ans.size() - 1) sb.append(", ");
        }
        sb.append('>');
        System.out.println(sb);
    }
}
