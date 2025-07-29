package arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {2,1,4};
//        int[] prices = {2,4,1};
        BestTimeToBuyAndSell bts = new BestTimeToBuyAndSell();

        System.out.println(bts.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int l = 0, r =1;

        int maxProfit = 0;

        while(r != prices.length){
            maxProfit = Math.max(prices[r] - prices[l] , maxProfit);
            l = prices[r] < prices[l]? r : l;
            r += 1;
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int price = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] != prices[j] && prices[j] - prices[i] > 0){
                    price = Math.max(price, prices[j] - prices[i]);
                }
            }
        }

        return price;
    }
}
