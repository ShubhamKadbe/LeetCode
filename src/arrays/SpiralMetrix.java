package arrays;

import java.util.*;

public class SpiralMetrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},
//                {19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};

                int[][] matrix = {{7},{9},{6}};

//        int[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},
//                {19,20,21,22,23,24},{25,26,27,28,29,30}};

//        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}, {17,18,19,20}};

        System.out.println(spiralMetrix(matrix));;
    }

    private static List spiralMetrix(int[][] matrix) {

        LinkedList list = new LinkedList();
        int left = 0, right = 0, up = 0, down = 0;
        int [] arrNum = matrix[0];
        int arrLength = arrNum.length, itr = arrLength-1, itr2 = matrix.length;
        boolean z = true;
        List numCount = new LinkedList();
        while (list.size() != arrLength*matrix.length){
            if(z){
                list.addAll(Arrays.stream(arrNum).boxed().toList());
                for (int j = 2; j <= matrix.length; j++) {
                    list.add(arrLength * j);
                    numCount.add(arrLength * j);
                    left = 1;
                }
                z = false;
            }
            else{
                z = true;
                while (list.size() != arrLength*matrix.length){

                   int x = (int) list.getLast();
                   z = false;
                    if(left == 1){
                        for (int k = 0; k < itr; k++) {
                            list.add(x - 1);
                            x = x -1;
                        }
                        left = 0; up = 1;
                        itr = itr - 1;
                        if (itr == 0) break;
                    }
                    if(up == 1){
                        int lastNum = (int) list.getLast();
                        for (int k = 0; k < itr2-2; k++) {
                            list.add(lastNum - arrLength);
                            x = x - 6;
                            lastNum = lastNum - arrLength;
                        }
                        up = 0;
                        right = 1;
                        itr2 = itr2 - 2;
                    }
                    if(right == 1){
                        int lastNum = (int) list.getLast();
                        for (int k = 0; k < itr; k++) {
                            list.add(lastNum + 1);
                            lastNum = lastNum + 1;
                        }
                        right = 0;
                        down = 1;
                        itr -= 1;
                        if (itr == 0) break;

                    }
                    if(down == 1){
                        int lastNum = (int) list.getLast();
                        for (int k = 0; k < itr2-1; k++) {
                            list.add(lastNum + arrLength);
                            lastNum = lastNum + arrLength;
                        }
                        down = 0;
                        left = 1;
                    }
                }
            }
        }
        return list;
    }
}
