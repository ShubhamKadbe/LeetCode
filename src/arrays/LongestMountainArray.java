package arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestMountainArray {

    public static void main(String[] args) {
        int [] arr = {2,1,4,7,3,2,5};
//        int [] arr = {0,1,2,3,4,5,4,3,2,1,0};
//        int [] arr = {0,2,0,2,1,2,3,4,4,1};
        System.out.println(longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {
        int l = 0, r = arr.length-1;
        int up = 0;
        int count = 0; //1,2,
        boolean init = false;
//        boolean peak = false;
//        boolean end = false;
        List<Integer> list = new ArrayList();
        while(l < arr.length-1){
            if(up == 0 && arr[l] < arr[l+1]){
                count++;
                init = true;
            }
            if (init && up == 0 && arr[l] > arr[l+1]){
                count++;
                up++;
            }
            if (up == 1 && arr[l] > arr[l+1]){
                count++;
            }
            if(up == 1 && (arr[l] < arr[l+1] || l+1 == arr.length-1)){
                if(count > 2){
                    list.add(count);
                    count = 0;
                    up = 0;
                }
            }
            l++;
        }
        System.out.println(list);
        return list.parallelStream().mapToInt(i -> i).max().orElse(0);
    }
}
