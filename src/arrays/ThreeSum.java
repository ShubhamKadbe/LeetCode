package arrays;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {
    public static void main(String[] args) {

//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0};
//        int[] nums = {-1,0,1,0};
//        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {  // [-4, -1, -1, 0, 1, 2]
            if(nums[i] > 0){
                break;
            }
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int init = nums[i],  left = i + 1, right = nums.length-1;
            while(left < right){
                int sum = init + nums[left] + nums[right];
                if(sum == 0){
                    threeSum.add((List.of(init, nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left ++;
                    right--;
                }else if(sum > 0){
                    right --;
                }else{
                    left ++;
                }
            }
        }
        return threeSum;
    }


        public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> indexMap = IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(i -> i, i -> nums[i]));
        System.out.println(indexMap);
        List<Integer> visited = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {  // {-1,0,1,2,-1,-4}
            for (int j = 0; j < nums.length; j++) {
                int temp = i != j ? nums[i] + nums[j] : 0;
                int sum = Math.abs(nums[i] *  nums[i]) + Math.abs(nums[j] * nums[j]) + Math.abs(temp * temp);
                if(i != j && indexMap.containsValue(temp * (-1)) && !visited.contains(sum) && temp*-1 != nums[i] && temp*-1 != nums[j] || (nums[0] == 0 && nums[1] == 0 && nums[2] == 0)){
                    List<Integer> subList = new ArrayList<Integer>();
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(indexMap.containsValue(temp * (-1)) ? temp * (-1) : 0);
                    visited.add(sum);
                    list.add(subList);
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(list);

        list.removeAll(list);
        list.addAll(set);

        return list;
    }
}
