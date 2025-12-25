package org.example.dfs.dfspractice;

import java.util.*;

public class Permutation {
    static int[] pm;
    static int n,m;
    public void DFS(int L){
        if(L==m) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation T = new Permutation();
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        pm= new int[m];
        T.DFS(0);
    }
}
