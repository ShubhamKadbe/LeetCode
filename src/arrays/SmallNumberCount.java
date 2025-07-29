package arrays;

import java.sql.Array;
import java.util.*;

public class SmallNumberCount {
    public static void main(String[] args) {
//        int [] arr = {7,7,7,7};
//        int [] arr = {8,1,2,2,3};
        int [] arr = {6,5,4,8};

        System.out.println(smallNumberCount3(arr));;
    }

    private static List smallNumberCount3(int[] arr) {  // 8,1,2,2,3
        List list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        List sortedList = Arrays.stream(arr).sorted().boxed().toList();
        Map map = new HashMap<>();
        for (int i = arr.length-1; i >= 0; i--) {
            map.put(sortedList.get(i), i);
        }
        System.out.println(map);

        for (int i = 0; i < arr.length; i++) {
                list.set(i, map.get(arr[i]));
        }
        return list;
    }

    private static List<Integer> smallNumberCount(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] - arr[j] != 0 && arr[i] - arr[j] > 0) {
                    temp++;
                }
            }
            list.add(temp);
            temp = 0;
        }

        return list;
    }

    // This (smallNumberCount2) is a partial solution.
    // It fails for array [7,7,7,7] which should give output of 0,0,0,0 but it gives false output 0,0,7,7

    private static List<Integer> smallNumberCount2(int[] arr) { // {8,1,2,3,3}

        // Output - 4,0,1,2,2
        List<Integer> unsortedList = Arrays.stream(arr).boxed().toList();
        List<Integer> unsortedList2 = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        int temp = 0;
        List<Integer> sortedList = unsortedList.stream().sorted().toList();
        System.out.println("Unsorted List : " + unsortedList );
        System.out.println("Sorted List : " + sortedList );
        for (int i = 0; i < arr.length; i++) {
            if(i != 0 && sortedList.get(i).equals(sortedList.get(i-1))){
                unsortedList2.set(unsortedList.indexOf(sortedList.get(i))+1, temp);
            }else {
                unsortedList2.set(unsortedList.indexOf(sortedList.get(i)), i);
                temp = i;
            }
        }

        return unsortedList2;
    }


}
