package searching;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] ar = {4, 1, 2, 6, 4, 1, 5, 9, 0, 1};
        countingSort(ar);
        for (int x : ar) {
            System.out.print(x + " ");
        }
    }

    private static void countingSort(int[] ar) {
        int n = ar.length;
        int[] output = new int[n];

        int max = ar[0];
        for (int a : ar) {
            if (a > max) {
                max = a;
            }
        }

        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        for (int a : ar) {
            ++count[a];
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int value : ar) {
            output[count[value] - 1] = value;
            --count[value];
        }

        System.arraycopy(output, 0, ar, 0, n);
    }
}
