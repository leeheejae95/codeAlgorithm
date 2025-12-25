package edu.code.third_st.problem;

import java.util.*;

public class Album {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        ArrayList<int[]> answer = new ArrayList<>();
        HashMap<String, Integer> genreTotalPlayDict = new HashMap<>(); // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        HashMap<String, ArrayList<int[]>> genreIndexPlayArrayDict = new HashMap<>(); // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        for(int i = 0; i < n; i++) {
            String genre = genres[i];
            int play = plays[i];
            if(genreTotalPlayDict.containsKey(genre)) {
                genreTotalPlayDict.put(genre, genreTotalPlayDict.get(genre) + play);
                genreIndexPlayArrayDict.get(genre).add(new int[]{i, play});
            } else {
                genreTotalPlayDict.put(genre, play);
                genreIndexPlayArrayDict.put(genre, new ArrayList<>());
                genreIndexPlayArrayDict.get(genre).add(new int[]{i, play});
            }
        }
        // Map.Entry : 키와 값이 동시에 필요로 할 때 사용
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(genreTotalPlayDict.entrySet()); // 키 : 장르 / 값 : 재생횟수
        Collections.sort(list, (a, b) -> Integer.compare(b.getValue(), a.getValue())); // 재생수가 높은 곡 내림정렬 genreTotalPlayDict: {pop=3100, classic=1450}

        for(Map.Entry<String, Integer> key : list) {
            String genre = key.getKey();
            ArrayList<int[]> genre_list = genreIndexPlayArrayDict.get(genre); // genre_list = pop, classic

            Collections.sort(genre_list, (a, b) -> a[1]==b[1] ? a[0]-b[0] : b[1]-a[1]); // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록한다.

            for(int i=0;i<Math.min(2, genre_list.size());i++) {
                // pop 정렬 후: [{4,2500}, {1,600}] → add: [4,2500], [1,600]
                // classic 정렬 후: [{3,800}, {0,500}, {2,150}] → add: [3,800], [0,500]
                answer.add(genre_list.get(i));
            }
        }

        int[] res = new int[answer.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = answer.get(i)[0];
        }

        return res;
    }

    public static void main(String[] args) {
        Album T = new Album();
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
