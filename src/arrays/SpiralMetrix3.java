package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpiralMetrix3 {
    public static void main(String[] args) {
//        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralMetrix(matrix));
    }

    private static List spiralMetrix(int[][] matrix) {
        LinkedList<LinkedList<Integer>> numList = new LinkedList<>();
        List list = new ArrayList();
        int left = matrix[0].length-1, right = left-2, up = matrix.length-2, down = up-1;

        for (int[] row : matrix) {
            numList.add(new LinkedList<>(Arrays.stream(row).boxed().toList()));
        }

        int stackSize = numList.getFirst().size(), total = matrix.length * stackSize;
        for (int i = 0; i <  1; i++) {
           numList.removeFirst().stream().forEach(a -> list.add(a));
        }


        while(total != list.size()) {

            // Down
            for (int i = 0; i < numList.size(); i++) {
                list.add(numList.get(i).removeLast());
            }

            // Left
            for (int i = 0; i < left; i++) {
                if (numList.getFirst().size() == 1) {
                    list.add(numList.get(0).removeLast());
                    numList.removeLast();
                    break;
                }
                if(!numList.isEmpty()) list.add(numList.getLast().removeLast());

            }
            if(!numList.isEmpty()) numList.removeLast();

            //Up
            for (int i = up - 1; i >= 0; i--) {
                list.add(numList.get(i).removeFirst());
                up -= up;
            }

            //Right
            for (int i = 0; i < right && !numList.isEmpty(); i++) {
                list.add(numList.get(0).removeFirst());
                if (numList.getFirst().size() == 1) {
                    list.add(numList.get(0).removeLast());
                    numList.removeFirst();
                }
            }
        }

        return list;
    }

}
