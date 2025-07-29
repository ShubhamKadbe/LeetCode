package arrays;

import javax.print.attribute.HashAttributeSet;
import java.util.*;
import java.util.stream.Collectors;

public class AllMissingNumbers {



    public static void main(String[] args) {

        int[] arr = {1,1,1,1};

        System.out.println(allMissingNumbers(arr));
    }

    private static Set<Integer> allMissingNumbers(int[] arr) {
        Set<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        Set list = new HashSet();
        int n = 0;
        int x = intList.size();
        int y = arr.length;

        int z = Arrays.stream(arr).max().getAsInt();
        if(y >= x && y >= z){
            n = y;
        } else if (x >= y && x >= z) {
            n = x;
        }else if (z >= x && z >= y){
            n = z;
        }
        for (int i = 1; i < n+1; i++) {
            if(!intList.contains(i)){
                list.add(i);
            }
        }
        return list;

    }
}
