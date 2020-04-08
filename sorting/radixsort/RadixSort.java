package sorting.radixsort;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] ar) {
        int max = getMax(ar);
        // start from one's place, then 10's and so on until all places are done
        for (int place = 1; max / place > 0; place *= 10) {
            countSort(ar, ar.length, place); // perform counting sort.
        }
    }

    private static int getMax(int[] ar) {
        int max = 0;
        for (int i : ar) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static void countSort(int[] ar, int n, int place) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            ++count[(ar[i] / place) % 10];
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(ar[i] / place) % 10] - 1] = ar[i];
            --count[(ar[i] / place) % 10];
        }
        for (int i = 0; i < n; i++) {
            ar[i] = output[i];
        }
    }
}