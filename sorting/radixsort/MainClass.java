package sorting.radixsort;

public class MainClass {
    public static void main(String[] args) {
        int[] ar = {4,1,2,6,4,1,5,9,0,1};
        RadixSort.sort(ar);
        for(int x:ar){
            System.out.println(x);
        }
    }
}
