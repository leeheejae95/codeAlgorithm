package programers.code;


import java.util.HashMap;

public class AthletesNotFinish {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantMap = new HashMap<>();

        for(String x : participant) participantMap.put(x, participantMap.getOrDefault(x,0)+1);

        for(String x : completion) participantMap.put(x, participantMap.get(x)-1);

        for(String key : participantMap.keySet()) {
            if(participantMap.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        AthletesNotFinish T = new AthletesNotFinish();
        String[] participant = {"mislav", "stanko", "mislav", "ana", "dasdsd"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(T.solution(participant, completion));
    }
}
