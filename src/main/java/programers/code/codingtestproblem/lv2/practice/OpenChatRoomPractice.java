package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class OpenChatRoomPractice {

    public String[] solution(String[] record) {
//        String[] answer = {};
        HashMap<String,String> enterMap = new HashMap<>();
        for(String recordInfo : record) {
            String result = recordInfo.split(" ")[0];
            String uid = recordInfo.split(" ")[1];
            String name = "";
            if(!result.equals("Leave")) {
                name = recordInfo.split(" ")[2];
                enterMap.put(uid, name);
            }
        }

        ArrayList<String> infoList = new ArrayList<>();
        for(String info : record) {
            String result = info.split(" ")[0];
            String uid = info.split(" ")[1];
            if(result.equals("Enter")) {
                infoList.add(enterMap.get(uid)+"님이 들어왔습니다.");
            } else if(!result.equals("Change") && !result.equals("Enter")){
                infoList.add(enterMap.get(uid)+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[infoList.size()];
        for(int i=0;i<infoList.size();i++) {
            answer[i] = infoList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChatRoomPractice T = new OpenChatRoomPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
}
