package sorting.mergesort;

public class MergeSort {
    public static void sort(int[] inputAr){
        sort(inputAr, 0, inputAr.length-1);
    }

    private static void sort(int[] inputAr, int startIdx, int endIdx){
        if(startIdx >= endIdx){
            return;
        }
        int midIdx = (startIdx + endIdx) / 2; // find mid
        sort(inputAr, startIdx, midIdx); // sort left array
        sort(inputAr, midIdx + 1, endIdx); // sort right array
        merge(inputAr, startIdx, midIdx, endIdx); // merge sorted arrays into input array
    }

    private static void merge(int[] inputAr, int startIdx, int midIdx, int endIdx){

        int[] tmpAr = new int[endIdx - startIdx + 1]; // end - start will give the total elements - 1 so, doing +1
        int leftSlot = startIdx; // starting slot of left array
        int rightSlot = midIdx + 1; // starting slot of right array
        int k = 0;

        // leftslot <= midIdx will become false once the loop exceeds mid which means end of left array
        // rightslot <= endIdx will become false once the loop exceeds endIdx which means end of right array
        while(leftSlot <= midIdx && rightSlot <= endIdx){
            if(inputAr[leftSlot] < inputAr[rightSlot]){
                tmpAr[k] = inputAr[leftSlot];
                leftSlot++;
            }else {
                tmpAr[k] = inputAr[rightSlot];
                rightSlot++;
            }
            k++;
        }

        // At this point, we can consider left and right sub-arrays to be sorted
        // But we need to double check whether tmpAr has all the sorted elements from left and right sub-arrays

        if(leftSlot <= midIdx){ // means that, left was already sorted. The above loop only sorted the right
            // so copy left array into tmpAr;
            while(leftSlot <= midIdx){
                tmpAr[k] = inputAr[leftSlot];
                leftSlot++;
                k++;
            }
        }else if(rightSlot <= endIdx) { // right was already sorted. Above loop only sorted the left
            while (rightSlot <= endIdx){
                tmpAr[k] = inputAr[rightSlot];
                rightSlot++;
                k++;
            }
        }

        // Copy tmpAr into inputAr
        for(int i = 0; i < tmpAr.length; i++){
            inputAr[startIdx + i] = tmpAr[i];
        }
    }
}
