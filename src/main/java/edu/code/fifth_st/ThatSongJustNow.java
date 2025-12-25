package edu.code.fifth_st;

public class ThatSongJustNow {

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String target = replaceWord(m); // 네오가 기억한 멜로디
        int bestTime = Integer.MIN_VALUE; // 가장 긴시간

        for(int i=0;i<musicinfos.length;i++) {
            String[] arr =  musicinfos[i].split(","); // {12:00, 12:14, HELLO, CDEFGAB}
            String start = arr[0];
            String end = arr[1];
            String title = arr[2];
            String score = replaceWord(arr[3]); // 악보패턴
            int playTime =  getTime(end) - getTime(start); // 종료시간 - 시작시간
            String played = make(score, playTime); // 재생된 전제 멜로디

            if(played.contains(target)) { // 재상한 노래중 네오가 기억한 포함이 되는지??
                if(playTime > bestTime) {
                    bestTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String m = "ABCDEFG"; // 네오가 기억한 멜로디
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));
    }

    public static String make(String str, int time) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for(int i=0; i<time;i++) {
            sb.append(str.charAt(i%n));
        }
        return sb.toString();
    }

    public static String replaceWord(String c) {
        return c.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    public static int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }
}
