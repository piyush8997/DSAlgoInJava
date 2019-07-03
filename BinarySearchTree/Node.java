package binarysearchtree;

public class Node {
    int data;
    Node leftChild;
    Node rightChild;

    Node(int data){
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
    }
}
