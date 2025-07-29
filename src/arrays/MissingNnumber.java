package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MissingNnumber {



    public static void main(String[] args) {

        int[] arr = {1,2,3,5,6};

        System.out.println(missingNumber2(arr));
    }

    private static int missingNumber(int[] arr) {

        OptionalInt x = Arrays.stream(arr).max();
        IntStream a = Arrays.stream(arr).sorted();

        int[] arr2 = a.toArray();
        if(x.isPresent()) {
            for (int i = 0; i < x.getAsInt(); i++) {
               if(arr2[i] != i){
                   return i;
               }else {
                   return x.getAsInt()+1;
               }
            }
        }
        return 0;
    }

    private static int missingNumber2(int[] arr) {
        int fullSum = IntStream.range(0, Arrays.stream(arr).max().getAsInt() + 1).sum();
        int sum = Arrays.stream(arr).sum();
        if( fullSum - sum == 0){
            return Arrays.stream(arr).max().getAsInt()+1;
        }
        return fullSum - sum;
    }

}
