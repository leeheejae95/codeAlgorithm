package org.example.dfs.dfspractice;

import java.util.Scanner;

public class Mixture {
    static int n,m;
    static int[] pm;
    public void DFS(int L, int s){
        if(L==m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i=s; i<=n; i++) {
                pm[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Mixture T = new Mixture();
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        pm= new int[m];
        T.DFS(0, 1);
    }
}
