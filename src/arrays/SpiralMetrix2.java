package arrays;

import java.util.*;
import java.util.stream.Collectors;


public class SpiralMetrix2 {
    public static void main(String[] args) {
//        int[][] nums = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};

        int [][] nums = {{2,3,4},
                {5,6,7},
                {8,9,10},
                {11,12,13},
                {14,15,16}};

//        int[][] nums = { { 1,  2,  3,  4,  5,  6,  7,  8,  9, 10},
//                         {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
//                         {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
//                         {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
//                         {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
//                         {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
//                         {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
//                         {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
//                         {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
//                         {91, 92, 93, 94, 95, 96, 97, 98, 99,100} };

//        int [][] nums = {{1,2,3},{4,5,6},{7,8,9}};
//        int [][] nums = {{2,5},{8,4},{0,-1}};
//        int [][] nums = {{1}};

        System.out.println(spiralMetrix2(nums));
//        spiralMetrix2(nums);

//        flattenRows(nums, 3);
    }

    public static List spiralMetrix2(int [][] nums) {
        LinkedList<LinkedList<Integer>> arrToList = new LinkedList();

        for (int[] arr : nums) arrToList.add(new LinkedList<>(Arrays.stream(arr).boxed().toList()));

        LinkedList list = new LinkedList() ;

//        System.out.println(arrToList.size() * arrToList.getFirst().size());

        int itr = arrToList.size() * arrToList.getFirst().size();

        while(list.size() < itr){
            if (!arrToList.isEmpty() && !arrToList.getFirst().isEmpty()){
                arrToList.removeFirst().forEach(a -> list.add(a));
            }

//            if(arrToList.isEmpty() && !arrToList.getFirst().isEmpty()) arrToList.remove(arrToList.getFirst());

//            System.out.println(list);

            if(list.size() == itr) break;

            if(arrToList.getLast().isEmpty()) arrToList.removeLast();
            if(arrToList.getFirst().isEmpty()) arrToList.removeFirst();

//            System.out.println(arrToList);
//            System.out.println(list);
            if(arrToList.size() == 0){
                break;
            }
            if(!arrToList.getLast().isEmpty()) {

//                System.out.println("isTrue");

                for (int i = 0; i < arrToList.size(); i++) {
                    if(!arrToList.get(i).isEmpty()){
                        list.add(arrToList.get(i).removeLast());}
                }
            }

            if(list.size() == itr) break;

            if(!arrToList.getLast().isEmpty()){
                int lastSize = arrToList.getLast().size();
                for (int i = 0; i < lastSize; i++) {
                    if(!arrToList.getLast().isEmpty()){
                        list.add(arrToList.getLast().removeLast());
                    }else{arrToList.removeLast();}
                }
            }

            if(!arrToList.isEmpty()) {
                int newSize = arrToList.size();
//                System.out.println(newSize);
//                System.out.println(arrToList);
//                System.out.println(list);
                for (int i = newSize-2; i >= 0; i--) {
//                    System.out.println(list);
                    list.add(arrToList.get(i).removeFirst());
//                    System.out.println(list);
                }
            }
        }
//        System.out.println(list);
        return list;
    }

    private static List spiralMetrix(int[][] nums) {
        LinkedList<LinkedList<Integer>> numList = new LinkedList<>();
        int numsSize = nums.length;

        List list = new ArrayList();

        int round = 0;
//        int up = round == 0? nums.length-2 : numList.size();
        int left = nums[0].length-1, right = left-2;

        for (int[] row : nums) {

            numList.add(new LinkedList<>(Arrays.stream(row).boxed().toList()));
//            numList.add(num);
        }
        int stackSize = numList.getFirst().size(), total = numsSize * stackSize;
        System.out.println("Stack Size : " + stackSize + " Total : " + total );

        for (int i = 0; i <  1; i++) {
            numList.removeFirst().stream().forEach(a -> list.add(a));
        }

//        System.out.println("N L : " + numList);

        while(total != list.size()) {
            int up = round == 0? nums.length-2 : numList.size() - 1, down = up-1;
            // Down
            for (int i = 0; i < numList.size(); i++) {
                list.add(numList.get(i).removeLast());
            }

            System.out.println("Down : " + list);
            System.out.println("Down : " + numList);

            // Left
            for (int i = 0; i < left; i++) {
                if (numList.getFirst().size() == 0) {
                    if(numList.getFirst().size() == 1)
                        list.add(numList.get(0).removeLast());
                    numList.removeLast();
                    break;
                }
                if(!numList.isEmpty() && !numList.getLast().isEmpty())
                    list.add(numList.getLast().removeLast());
            }
            if(!numList.isEmpty()) numList.removeLast();

            System.out.println("Left : " + list);
            System.out.println("Left : " + numList);

            //Up
            for (int i = up - 1; i >= 0; i--) {
                if (i >= numList.size()) continue; // safety check
                LinkedList<Integer> row = numList.get(i);

                if (!row.isEmpty()) {
                    list.add(row.removeFirst());
                }
                if (row.isEmpty()) {
                    numList.remove(i);
                }
                if (numList.size() == 1 && numList.get(0).size() == 1) {
                    list.add(numList.get(0).removeFirst());
                    numList.remove(0);
                    break;
                }
            }


            System.out.println("Up : " + list);
            System.out.println("Up : " + numList);

            //Right
            for (int i = 0; i < right && !numList.isEmpty(); i++) {
                if (numList.getFirst().size() > 1)
                    list.add(numList.get(0).removeFirst());
                if (numList.getFirst().size() == 1) {
                    list.add(numList.get(0).removeLast());
                    numList.removeFirst();
                }
            }

            System.out.println("Right : " + list);
            System.out.println("Right : " + numList);

            round = round + 1;
        }

        return list;
    }



}
