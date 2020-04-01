package sorting;

public class ShellSort {
    public static void main(String[] args) {
        int[] ar = {50, 3, 4, 1, 25};
        shellSort(ar);

        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    private static void shellSort(int[] ar) {
        int n = ar.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int element = ar[i];
                int j = i;
                while (j >= gap && ar[j - gap] > element) {
                    ar[j] = ar[j - gap];
                    j -= gap;
                }
                ar[j] = element;
            }
        }
    }
}