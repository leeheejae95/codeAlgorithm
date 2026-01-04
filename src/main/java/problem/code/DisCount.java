package problem.code;

import java.util.Arrays;
import java.util.Collections;

public class DisCount {
    public int solution(int[] prices, int[] discount) {
        Integer[] price = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] cupon = Arrays.stream(discount).boxed().toArray(Integer[]::new);
        Arrays.sort(price, Collections.reverseOrder()); // 150000 30000 2000
        Arrays.sort(cupon, Collections.reverseOrder()); // 40 20

        int priceIdx = 0;
        int cuponIdx = 0;
        int sum = 0;

        while(priceIdx < price.length && cuponIdx < cupon.length) {
            sum += price[priceIdx] * (100 - cupon[cuponIdx]) /100;
            priceIdx++;
            cuponIdx++;
        }
        while (priceIdx < price.length) {
            sum += price[priceIdx];
            priceIdx++;
        }

        return sum;
    }

    public static void main(String[] args) {
        DisCount T = new  DisCount();
        System.out.println(T.solution(new int[]{30000, 2000, 1500000}, new int[]{20, 40}));
        System.out.println(T.solution(new int[]{50000, 1500000}, new int[]{10, 70, 30, 20}));
        System.out.println(T.solution(new int[]{50000, 1500000}, new int[]{}));
        System.out.println(T.solution(new int[]{20000, 100000, 1500000}, new int[]{10, 10, 10}));
    }
}
