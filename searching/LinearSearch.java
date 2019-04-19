package searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] ar = {20, 42, 75, 96, 100};
        int key = 42;

        int idx = linearSearch(ar, key);
        if (idx < 0) {
            System.out.printf("%d not found", key);
        } else {
            System.out.printf("%d found at index %d", key, idx);
        }
    }

    private static int linearSearch(int[] ar, int key) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
