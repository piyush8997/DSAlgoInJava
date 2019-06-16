package sorting.QuickSort;

public class QuickSort {
    public static void sort(int[] inputAr){
        sort(inputAr, 0, inputAr.length-1);
    }
    private static void sort(int[] inputAr, int startIdx, int endIdx){
        if(startIdx < endIdx){
            // Get the position of perfectly placed value in array
            int partitionIdx = partition(inputAr, startIdx, endIdx);
            // Sort left array from start to partition - 1 idx.
            sort(inputAr, startIdx, partitionIdx - 1);
            // sort right array from partition + 1 to end.
            sort(inputAr, partitionIdx + 1, endIdx);
        }
    }
    private static int partition(int[] inputAr, int startIdx, int endIdx){
        // Initialize a pivot
        int pivot = inputAr[endIdx];

        // Initialize i = startIdx - 1;
        int i = startIdx - 1; // starts from -1;

        // For loop to check pivot with other elements in the array
        for(int j = startIdx; j <= endIdx - 1; j++){ // Not considering pivot in loop so j <= endIdx - 1
            if(inputAr[j] <= pivot){ // Check element at j idx is less or equal to pivot element
                i++; // If yes, then increment i;
                // swap element at i and j
                int tmp = inputAr[i];
                inputAr[i] = inputAr[j];
                inputAr[j] = tmp;
            }
        }

        // after exiting the loop, all the smaller elements will be at the left.
        // now, move pivot at the correct place which is i + 1.
        // so swap inputAr[end] (pivot) with inputAr[i+1]
        int tmp = inputAr[i+1];
        inputAr[i+1] = inputAr[endIdx];
        inputAr[endIdx] = tmp;

        return (i+1);
    }
}
