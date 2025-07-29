package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*

Problem Statement:
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Examples:
- Example 1:
Input: nums = [1, 2, 3, 1]
Output: true
- Example 2:
Input: nums = [1, 2, 3, 4]
Output: false
- Example 3:
Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true
Constraints:
- 1 \leq \text{nums.length} \leq 10^5
- -10^9 \leq \text{nums[i]} \leq 10^9

*/
public class DuplicateValues {

    public static boolean duplicateValues(int[] a){

        Set<Integer> seen = new HashSet<Integer>();
        int[] b = Arrays.stream(a).distinct().toArray();
//        Set<Integer> duplicates = Arrays.stream(a).filter(y -> !seen.add(y)).collect(Collectors.toUnmodifiableSet());
        if(b.length < a.length){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int [] a = {1,2,3,3};
        System.out.println(duplicateValues(a));
    }

}
