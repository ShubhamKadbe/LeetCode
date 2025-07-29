package arrays;

import java.util.*;
import java.util.stream.IntStream;

public class SquareOfSortedArray {
    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
//        int [] nums = {-7,-3,2,3,11};
//        int [] nums = {2,3,11};
//        System.out.println(Arrays.stream(sortedSquares(nums)).boxed().toList());
        System.out.println(Arrays.stream(sortedSquares2(nums)).boxed().toList());
//        sortedSquares(nums);
    }

    private static int[] sortedSquares2(int[] nums) {
        int [] sortedSquare = new int[nums.length];
        IntStream.range(0, nums.length).forEach(i -> sortedSquare[i] = nums[i]*nums[i]);
        return Arrays.stream(sortedSquare).sorted().toArray();
    }

    private static int[] sortedSquares(int[] nums) {  // {-4,-1,0,3,10}
        int l = 0, r = nums.length-1;
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<Integer>();
        while(l <= r){
            if(Math.abs(nums[l]) < Math.abs(nums[r])){
                list.addFirst(nums[r] * nums[r]);
                r -= 1;
            }else{
                list.addFirst(nums[l]*nums[l]);
                l += 1;
            }
        }
        return list.stream().mapToInt(value -> value).toArray();
    }

}
