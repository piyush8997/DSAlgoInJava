package binarysearchtree;

import java.util.Queue;

import java.util.LinkedList;
import java.util.Stack;

public class BST {

    private Node rootNode;

    public void insert(int data){
        Node newNode = new Node(data);
        if(rootNode == null){
            rootNode = newNode;
        }else{
            Node currentNode = rootNode;
            Node parentNode;
            while (true){
                parentNode = currentNode;
                if(data < currentNode.data){
                    currentNode = currentNode.leftChild;
                    if(currentNode == null){
                        parentNode.leftChild = newNode;
                        return;
                    }
                }else{
                    currentNode = currentNode.rightChild;
                    if(currentNode == null){
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node getMaxNode(){
        Node parentNode = rootNode;
        Node currentNode = rootNode;
        while(currentNode != null){
            parentNode = currentNode;
            currentNode = currentNode.rightChild;
        }
        return parentNode;
    }

    public Node getMinNode(){
        Node parentNode = rootNode;
        Node currentNode = rootNode;
        while (currentNode!=null){
            parentNode = currentNode;
            currentNode = currentNode.leftChild;
        }
        return parentNode;
    }

    public boolean delete(int data){
        // search for node
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = false;
        while (currentNode.data != data){
            parentNode = currentNode;
            if(data < currentNode.data){
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            }else{
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
            if(currentNode == null){
                return false;
            }
        }

        Node nodeToDelete = currentNode;
        // no child
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if(nodeToDelete == rootNode){
                rootNode = null;
            }else if(isLeftChild){
                parentNode.leftChild = null;
            }else{
                parentNode.rightChild = null;
            }
        // only one child
        }else if(nodeToDelete.rightChild == null){
            if(nodeToDelete == rootNode){
                rootNode = nodeToDelete.leftChild;
            }else if(isLeftChild){
                parentNode.leftChild = nodeToDelete.leftChild;
            }else{
                parentNode.rightChild = nodeToDelete.leftChild;
            }
        }else if(nodeToDelete.leftChild == null){
            if(nodeToDelete == rootNode){
                rootNode = nodeToDelete.rightChild;
            }else if(isLeftChild){
                parentNode.leftChild = nodeToDelete.rightChild;
            }else{
                parentNode.rightChild = nodeToDelete.rightChild;
            }
        // both children
        }else{
            Node successorNode = getSuccessorNode(nodeToDelete);
            if(nodeToDelete == rootNode){
                rootNode = successorNode;
            }else if(isLeftChild){
                parentNode.leftChild = successorNode;
            }else{
                parentNode.rightChild = successorNode;
            }

            successorNode.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    private Node getSuccessorNode(Node nodeToDelete){
        Node successorNode = nodeToDelete;
        Node successorParentNode = nodeToDelete;
        Node currentNode = nodeToDelete.rightChild;

        while (currentNode != null){
            successorParentNode = successorNode;
            successorNode = currentNode;
            currentNode = currentNode.leftChild;
        }

        if(successorNode!=nodeToDelete.rightChild){
            successorParentNode.leftChild = successorNode.rightChild;
            successorNode.rightChild = nodeToDelete.rightChild;
        }

        return successorNode;
    }

    public void BFSTraversal(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()){
            Node tmpNode = queue.poll();
            System.out.printf("%d ",tmpNode.data);
            if(tmpNode.leftChild!=null){
                queue.add(tmpNode.leftChild);
            }
            if(tmpNode.rightChild!=null){
                queue.add(tmpNode.rightChild);
            }
        }
        System.out.println();
    }

    public void inOrderDFSTraversal(){
        Stack<Node> stack = new Stack<>();
        Node current = rootNode;
        boolean bDone = false;
        while (!bDone){
            if(current!=null){
                stack.push(current);
                current = current.leftChild;
            }else{
                if(stack.isEmpty()){
                    bDone = true;
                }else {
                    Node n = stack.pop();
                    System.out.printf("%d ",n.data);
                    current = n.rightChild;
                }
            }
        }
        System.out.println();
    }
}
