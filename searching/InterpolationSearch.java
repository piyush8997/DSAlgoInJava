package searching;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] ar = {20, 42, 75, 96, 100};
        int key = 96;

        int idx = interpolationSearch(ar, key);
        if (idx < 0) {
            System.out.printf("%d not found", key);
        } else {
            System.out.printf("%d found at index %d", key, idx);
        }
    }

    private static int interpolationSearch(int[] ar, int key) {
        int start = 0, end = ar.length - 1;
        while (start <= end && key >= ar[start] && key <= ar[end]) {
            if (start == end) {
                if (ar[start] == key) {
                    return start;
                }
                return -1;
            }
            int pos = start + (((key - ar[start]) * (end - start)) / (ar[end] - ar[start]));
            if (key == ar[pos]) {
                return pos;
            }
            if (key < ar[pos]) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
        }
        return -1;
    }
}