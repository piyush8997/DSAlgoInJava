package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] ar = {5,2,4,1,3};
        insertionSort(ar);

        for(int x:ar){
            System.out.println(x);
        }
    }

    private static void insertionSort(int[] ar){
        // start from i=1 to ar.length-1. i=0 element is considered as sorted
        for(int i=1;i<ar.length;i++){
            // pick an element
            int element = ar[i];

            // initialize j
            int j = i-1;

            // check inside while loop
            while(j>=0 && ar[j] > element){
                // swap part 1
                ar[j+1] = ar[j];
                j--;
            }
            // swap part 2
            ar[j+1] = element;
        }
    }
}
