package programers.code.codingtestproblem.lv2;

import java.util.*;

public class ParkingFeeCalculation {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }

    public int[] solution(int[] fees, String[] records) {
        // fees : 기본시간, 기본요금, 단위시간, 단위요금
//        int[] answer = {};
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();
        for(String info : records) {
            int time = getTime(info.split(" ")[0]);
            String carNUm = info.split(" ")[1];
            String result = info.split(" ")[2]; // IN OUT
            if(result.equals("IN")) inMap.put(carNUm, time);
            else {
                int timeResult = time - inMap.getOrDefault(carNUm,0); // 출차 - 입차
                sumMap.put(carNUm, sumMap.getOrDefault(carNUm,0) + timeResult);
                inMap.remove(carNUm); // 출차됐으니 맵에서 제거
            }
        }

        int endTime = getTime("23:59");
        for(String key : inMap.keySet()) { // 입차만하고 출차는 안한 차량은 23:59에 출차한것으로 보기
            int parKingTime = endTime - inMap.get(key);
            sumMap.put(key, sumMap.getOrDefault(key,0)+parKingTime);
        }

        ArrayList<Integer> parkingPay = new ArrayList<>();
        ArrayList<Map.Entry<String,Integer>> parkList = new ArrayList<>(sumMap.entrySet());
        parkList.sort((a, b) -> a.getKey().compareTo(b.getKey())); // 차량번호가 작은순으로 정렬

        for(Map.Entry<String,Integer> key : parkList) {
            int totalTime = key.getValue();
            int fee = fees[1];
            // 기본 주차시간보다 오래주차할 경우 금액 구하기
            if(totalTime > fees[0]) fee += (int)Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
            parkingPay.add(fee);
        }

        int[] answer = new int[parkingPay.size()];
        for(int i=0;i<parkingPay.size();i++) answer[i] = parkingPay.get(i);

        return answer;
    }

    public static void main(String[] args) {
        ParkingFeeCalculation T = new ParkingFeeCalculation();
        System.out.println(Arrays.toString(T.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(T.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
    }
}
