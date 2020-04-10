package searching;

public class TernarySearch {
    public static void main(String[] args) {
        int[] ar = {20, 42, 75, 96, 100};
        int key = 96;

        int idx = ternarySearch(ar, key);
        if (idx < 0) {
            System.out.printf("%d not found", key);
        } else {
            System.out.printf("%d found at index %d", key, idx);
        }
    }

    private static int ternarySearch(int[] ar, int key) {
        int start = 0, end = ar.length - 1;
        while (start <= end) {
            int mid1 = start + (end - start);
            int mid2 = end - (end - start);
            if (key == ar[mid1]) {
                return mid1;
            }
            if (key == ar[mid2]) {
                return mid2;
            }
            if (key < ar[mid1]) {
                end = mid1 - 1;
            } else if (key > ar[mid2]) {
                start = mid2 + 1;
            } else {
                start = mid1 + 1;
                end = mid2 - 1;
            }
        }
        return -1;
    }
}