package BinarySearchTree;

public class MainClass {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10, "ten");
        bst.insert(20,"twenty");
        bst.insert(4,"four");

        System.out.println(String.format("Minimum: %d | Maximum: %d", bst.findMin().key,bst.findMax().key));
        System.out.println(bst.remove(4));
        System.out.println(String.format("Minimum: %d | Maximum: %d", bst.findMin().key,bst.findMax().key));

    }
}
