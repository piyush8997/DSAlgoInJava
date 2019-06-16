package sorting.mergesort;

public class MainClass {
    public static void main(String[] args) {
        int[] ar = {4,1,2,6,4,1,5,9,0,1};
        MergeSort.sort(ar);
        for(int x:ar){
            System.out.println(x);
        }
    }
}
