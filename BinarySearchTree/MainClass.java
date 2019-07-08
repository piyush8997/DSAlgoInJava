package binarysearchtree;

public class MainClass {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(10);
        bst.insert(1);
        bst.insert(40);
        bst.insert(2);
        bst.insert(20);
        bst.insert(30);

        System.out.println(String.format("Max: %d | Min: %d", bst.getMaxNode().data, bst.getMinNode().data));

        bst.delete(40);

        System.out.println(String.format("Max: %d | Min: %d", bst.getMaxNode().data, bst.getMinNode().data));

        System.out.println("BFS Traversal");
        bst.BFSTraversal();
		
        System.out.println("DFS InOrder Traversal");
        bst.inOrderDFSTraversal();
		
		System.out.println("DFS PreOrder Traversal");
        bst.preOrderDFSTraversal();

        System.out.println("DFS PostOrder Traversal");
        bst.postOrderDFSTraversal();
		
		System.out.println((bst.isPresentInTree(20))?"Present":"Not Present");
        System.out.println((bst.isPresentInTree(40))?"Present":"Not Present");
        System.out.printf("Size of tree: %d\n", bst.getTreeSize());
    }
}
