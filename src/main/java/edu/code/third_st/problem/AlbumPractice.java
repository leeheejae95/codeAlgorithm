package edu.code.third_st.problem;

import java.util.*;

public class AlbumPractice {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        ArrayList<int[]> answer = new  ArrayList<>();
        HashMap<String, Integer> totalPlays = new HashMap<>();
        HashMap<String, ArrayList<int[]>> indexPlay = new HashMap<>();
        for(int i=0; i<n; i++) {
            String genre = genres[i];
            int play = plays[i];
            if(totalPlays.containsKey(genre)) {
                totalPlays.put(genre, totalPlays.get(genre)+play);
                indexPlay.get(genre).add(new int[]{i, play}); // pop : {0, 100}
            }else {
                totalPlays.put(genre, play); // pop : 100
                indexPlay.put(genre, new ArrayList<>());
                indexPlay.get(genre).add(new int[]{i,play}); // pop : {0, 100}
            }
        }
        // pop : {1,600}, {4,2500}
        // classic : {{0,500}, {2,150}, {3,800}}
        // classic : 1450, pop : 3100
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(totalPlays.entrySet());
        // pop : 3100, classic : 1450
        list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<String, Integer> entry : list) {
            String key = entry.getKey();
            ArrayList<int[]> genre_list = indexPlay.get(key); // pop , classic
            Collections.sort(genre_list, (a, b) -> a[1]==b[1] ? a[0]-b[0] : b[1]-a[1]);

            for(int i=0; i<Math.min(2,  genre_list.size());i++) {
                answer.add(genre_list.get(i));
            }
        }
        int[] res = new int[answer.size()];
        for(int i=0; i<res.length; i++) {
            res[i] =  answer.get(i)[0];
        }
        return res;
    }

    public static void main(String[] args) {
        AlbumPractice T = new AlbumPractice();
        System.out.print("정답 = [4, 1, 3, 0] / 현재 풀이 값 = ");
        System.out.println(Arrays.toString(
                T.solution(new String[]{"classic","pop","classic","classic","pop"},
                        new int[]{500,600,150,800,2500})
        ));

        System.out.print("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = ");
        System.out.println(Arrays.toString(
                T.solution(new String[]{"hiphop","classic","pop","classic","classic","pop","hiphop"},
                        new int[]{2000,500,600,150,800,2500,2000})
        ));
    }
}
