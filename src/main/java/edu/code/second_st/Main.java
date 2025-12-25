package edu.code.second_st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static ArrayList<Integer> solution(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1; i<=n; i++) nums.add(i);

        int tmp = 0;
        while(!nums.isEmpty()) {
            tmp = (tmp + k -1) % nums.size();
            res.add(nums.remove(tmp));
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ans = solution(n,m);

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for(int i=0; i<ans.size(); i++) {
            sb.append(ans.get(i));
            if(i < ans.size() -1) sb.append(", ");
        }
        sb.append('>');
        System.out.println(sb);
    }
}