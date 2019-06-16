package sorting.QuickSort;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int[] ar = {5,0,1,4,10,2};
        QuickSort.sort(ar);

        System.out.println(Arrays.toString(ar));
    }
}
