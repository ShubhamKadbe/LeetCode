package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSums {


    public static void main(String[] args) {
        int[] nums = {2,3,5,7,8,10};
        int target = 13;
        System.out.println(twoSums3(nums, target));;
    }

    private static Set<Integer> twoSums(int[] nums, int target) {
        Set<Integer> output = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target && i != j){
                    output.add(i);
                    output.add(j);
                    if(output.size() == 2){
                        break;
                    }
                }
            }
            if(output.size() == 2){
                break;
            }
        }

        return output;
    }

    private static Set<Integer> twoSums2(int[] nums, int target) {  // (2,3,5,7,8), 13
        Set<Integer> output = new HashSet<Integer>();

       List list = Arrays.stream(nums).boxed().toList();

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            temp = target - nums[i];
            if(list.contains(temp)){
                output.add(list.indexOf(temp));
                output.add(i);
            }
        }

        return output;
    }

    private static List<Integer> twoSums3(int[] nums, int target) {  // (2,3,5,7,8), 13
        Map map = new HashMap<>();
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            map.put(nums[i], i);
            if(map.containsKey(temp)){
                list.add(i);
                list.add(map.get(temp));
            }
        }
        return list;
    }
}
