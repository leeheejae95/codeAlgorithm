package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class ParkingFeeCalculationPractice {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public int[] solution(int[] fees, String[] records) {
        // fees : 기본시간, 기본요금, 단위시간, 단위요금
//        int[] answer = {};
        HashMap<String,Integer> inMap = new HashMap<>();
        HashMap<String,Integer> sumMap = new HashMap<>();
        for(String info : records) {
            int time = getTime(info.split(" ")[0]);
            String carNum = info.split(" ")[1];
            String result = info.split(" ")[2];
            if(result.equals("IN")) inMap.put(carNum, time);
            else { // OUT일 경우
                int timeResult = time - inMap.getOrDefault(carNum,0); // 출차 - 입차
                sumMap.put(carNum, sumMap.getOrDefault(carNum,0) + timeResult); // 누적
                inMap.remove(carNum);
            }
        }

        // 출차안된 차량 시간 구하기
        int endTime = getTime("23:59");
        for(String carNum : inMap.keySet()) {
            int time = endTime - inMap.get(carNum);
            sumMap.put(carNum, sumMap.getOrDefault(carNum,0)+time);
        }

        ArrayList<Map.Entry<String,Integer>> parkInfo = new ArrayList<>(sumMap.entrySet());
        ArrayList<Integer> feeList = new ArrayList<>();
        parkInfo.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        for(Map.Entry<String,Integer> carNum : parkInfo) {
            int total = carNum.getValue(); // 초과금액
            int fee = fees[1]; // 기본요금
            if(total > fees[0]) fee += (int)Math.ceil((double)(total-fees[0])/fees[2]) * fees[3];
            feeList.add(fee);
        }

        int[] answer = new int[feeList.size()];
        for(int i=0;i< feeList.size();i++) answer[i] = feeList.get(i);

        return answer;
    }

    public static void main(String[] args) {
        ParkingFeeCalculationPractice T = new ParkingFeeCalculationPractice();
        System.out.println(Arrays.toString(T.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(T.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
    }
}
