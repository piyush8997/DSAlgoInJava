package searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] ar = {20, 42, 75, 96, 100};
        int key = 96;

        int idx = binarySearch(ar, key);
        if (idx < 0) {
            System.out.printf("%d not found", key);
        } else {
            System.out.printf("%d found at index %d", key, idx);
        }
    }

    private static int binarySearch(int[] ar, int key) {
        int left = 0;
        int right = ar.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (ar[mid] == key) {
                return mid;
            }
            if (key < ar[mid]) {
                right = mid - 1;
            } else if (key > ar[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
