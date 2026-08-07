package programers.code.codingtestproblem.lv2;

import java.util.*;

public class OpenChatRoom {

    public String[] solution(String[] record) {
//        String[] answer = {};
        HashMap<String,String> nickNameMap = new HashMap<>();
        ArrayList<String> resultInfo = new ArrayList<>();
        for(String info : record) {
            String result = info.split(" ")[0];
            String uid = info.split(" ")[1];
            String name = "";
            if(!result.equals("Leave")) {
                name = info.split(" ")[2];
                nickNameMap.put(uid, name);
            }
        }

        System.out.println(nickNameMap);

        for(String info : record) {
            String result = info.split(" ")[0];
            String uid = info.split(" ")[1];
            if(result.equals("Enter"))resultInfo.add(nickNameMap.get(uid) + "님이 들어왔습니다.");
            else if(!result.equals("Change") && !result.equals("Enter")) resultInfo.add(nickNameMap.get(uid) + "님이 나갔습니다.");
        }

        String[] answer = new String[resultInfo.size()];
        for(int i=0;i< resultInfo.size();i++) {
            answer[i] = resultInfo.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChatRoom T = new OpenChatRoom();
        System.out.println(Arrays.toString(T.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
}
