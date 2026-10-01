package programers.code.codingtestproblem.lv2.practice;

public class JustPlayedPractice {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        m = m.replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g")
                .replace("A#","a");

        for(String musicInfo : musicinfos) {
            int start = getTime(musicInfo.split(",")[0]);
            int end = getTime(musicInfo.split(",")[1]);
            int timeDiff = end- start;
            String title = musicInfo.split(",")[2];
            String play = musicInfo.split(",")[3];
            play = play.replace("C#","c")
                    .replace("D#","d")
                    .replace("F#","f")
                    .replace("G#","g")
                    .replace("A#","a");

            StringBuilder sb = new StringBuilder();
            while(sb.length()<timeDiff) sb.append(play);
            String played = sb.substring(0,timeDiff);

            if(played.contains(m)) {
                if(timeDiff > max) {
                    max = timeDiff;
                    answer = title;
                }
            }
        }

        return answer.isEmpty() ? "(None)": answer;
    }

    public static void main(String[] args) {
        JustPlayedPractice T = new JustPlayedPractice();
        System.out.println(T.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(T.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(T.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}
