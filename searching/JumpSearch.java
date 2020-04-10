package searching;

public class JumpSearch {
    public static void main(String[] args) {
        int[] ar = {20, 42, 75, 96, 100};
        int key = 96;

        int idx = jumpSearch(ar, key);
        if (idx < 0) {
            System.out.printf("%d not found", key);
        } else {
            System.out.printf("%d found at index %d", key, idx);
        }
    }

    private static int jumpSearch(int[] ar, int key) {
        int n = ar.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        // finding correct block.
        while (ar[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }
        // perform linear search
        while (ar[prev] < key) {
            prev++;
            // if we reached next block or end of array
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (ar[prev] == key) {
            return prev;
        }
        return -1;
    }
}