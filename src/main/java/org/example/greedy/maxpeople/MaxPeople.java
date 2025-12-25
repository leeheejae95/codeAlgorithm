package org.example.greedy.maxpeople;

import java.util.*;
// 그리디, 시뮬레이션 문제
public class MaxPeople {
    public int solution(int n, int[][] trains, int[][] bookings){
        int answer=0;
        int[] sum = new int[n+1];
        for(int[] x : trains) {
            sum[x[0]] += x[2]; // 승차역에서 x[2]명탐
            sum[x[1]] -= x[2]; // 하차역에서 x[2]명 내림
        }
        for(int i=1; i<=n; i++) {
            sum[i] += sum[i-1]; // 전역에서 몇명을 태우고 이번역에서는 몇명을 태울수 있는지 계산
        }
        int bN = bookings.length;
        int idx = 0;
        Arrays.sort(bookings,(a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]); // 승차역이 빠른 순으로 정렬
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            while(!nums.isEmpty() && nums.peek() == i) { // 도착해서 내리는 어린이가 있는지 확인하기
                answer++;
                nums.pollFirst();
            }
            while(idx < bN && bookings[idx][0] == i) { // i번역에서 승차하는 어린이 확인하기
                nums.add(bookings[idx][1]);
                idx++;
            }
            Collections.sort(nums); // 도착역이 빠른 순으로 정렬
            while(nums.size() > sum[i]) { // 수용 인원이 다 차있을 경우 못타게 하기
                nums.pollLast();
            }
        }

        return answer;
    }

    public static void main(String[] args){
        MaxPeople T = new MaxPeople();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
