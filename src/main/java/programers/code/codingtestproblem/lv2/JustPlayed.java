package programers.code.codingtestproblem.lv2;

public class JustPlayed {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = 0;
        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
        for(String s : musicinfos) {
            int startTime = getTime(s.split(",")[0]);
            int entTime = getTime(s.split(",")[1]);
            int timeDiff = entTime-startTime;
            String title = s.split(",")[2];
            String sheetMusic = s.split(",")[3];

            sheetMusic = sheetMusic.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");

            StringBuilder sb = new StringBuilder();
            while(sb.length() < timeDiff) sb.append(sheetMusic);
            String played = sb.substring(0,timeDiff); // 재생된 음악음

            if(played.contains(m)) { // 재생시간이 제일 긴 음악
                if(timeDiff > maxTime) {
                    maxTime = timeDiff;
                    answer = title;
                }
            }
        }

        return answer.isEmpty() ? "(None)" : answer;
    }

    public static void main(String[] args) {
        JustPlayed T = new JustPlayed();
        System.out.println(T.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(T.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(T.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}
