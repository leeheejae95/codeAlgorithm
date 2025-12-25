package org.example.simulation.fruit;

public class Fruit {
    public int getMin(int[] fruit){ // 어떤 학생의 과일 정보
        int min = 100;
        for(int x : fruit){
            min = Math.min(min, x);
        }
        return min; // 최솟값 리턴
    }
    public Boolean isMinUnique(int[] fruit){ // 어떤 학생의 과일 정보에서 최솟값 갯수 찾기
        int cnt = 0;
        int min = getMin(fruit);
        for(int x : fruit){
            if(x == min) cnt++;
        }
        return cnt == 1;
    }
    public int getMinIndex(int[] fruit){ // 학생의 최솟값이 몇번 인덱스에 있는지
        int min = getMin(fruit);
        for(int i = 0; i < 3; i++){
            if(fruit[i] == min) return i;
        }
        return 0;
    }

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for(int i = 0; i < n; i++){
            if(ch[i] == 1) continue; // 한번 교환한 학생이면 넘어가기
            if(isMinUnique(fruit[i]) == false) continue; // 최솟값이 유니크하지 않은 학생이면 넘어가기
            for(int j = i+1; j < n; j++){
                if(ch[j] == 1) continue; // 한번 교환한 학생이면 넘어가기
                if(isMinUnique(fruit[j]) == false) continue; // 최솟값이 유니크하지 않은 학생이면 넘어가기
                int a = getMinIndex(fruit[i]); // i번 학생의 최솟값 과일
                int b = getMinIndex(fruit[j]); // j번 학생의 최솟값 과일
                if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0){
                    if(fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1){ // i번째 학생이 받은 과일이 j번째 학생에게 준 과일보다 커야됨 ( 최솟값 유지 )
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1; // i번 학생 교환 했음 체크
                        ch[j] = 1; // j번 학생 교환 했음 체크
                        break;
                    }
                }
            }
        }
        for(int[] x : fruit){
            answer += getMin(x);
        }
        return answer;
    }

    public static void main(String[] args){
        Fruit T = new Fruit();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
