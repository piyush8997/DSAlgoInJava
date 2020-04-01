package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] ar = {50, 3, 4, 1, 25};
        selectionSort(ar);

        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] < ar[min]) {
                    min = j;
                }
            }
            int tmp = ar[i];
            ar[i] = ar[min];
            ar[min] = tmp;
        }
    }
}
