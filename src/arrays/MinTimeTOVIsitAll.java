package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeTOVIsitAll {
    public static void main(String[] args) {
//        int [][] numList = {{6,3}, {9,1}, {2,4}, {1,0}};
        int [][] numList = {{1,1}, {3,4}, {-1,0}};
        System.out.println(Arrays.deepToString(numList));

        System.out.println(minTimeTOVIsitAllPoints(numList));;

    }



    private static int minTimeTOVIsitAllPoints(int[][] numList) {

        int count = 0;

        for (int i = 0; i < numList.length-1; i++) {
                int[] nums = numList[i];
                int[] nextNum = numList[i + 1];
                count = count + Math.max(Math.abs(nums[0] - nextNum[0]), Math.abs(nums[1] - nextNum[1]));
        }
        return count;
    }


}
