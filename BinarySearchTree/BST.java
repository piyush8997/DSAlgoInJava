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
	
	public void preOrderDFSTraversal(){
        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()){
            Node n = stack.pop();
            System.out.printf("%d ", n.data);
            if(n.rightChild!=null){
                stack.push(n.rightChild);
            }
            if(n.leftChild!=null){
                stack.push(n.leftChild);
            }
        }
        System.out.println();
    }

    public void postOrderDFSTraversal(){
        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);
        Node prev = null;
        while (!stack.isEmpty()){
            Node current = stack.peek();
            if(prev == null || prev.leftChild == current || prev.rightChild == current){
                if(current.leftChild != null){
                    stack.push(current.leftChild);
                }else if(current.rightChild != null){
                    stack.push(current.rightChild);
                }
            }else if(prev == current.leftChild){
                if(current.rightChild != null){
                    stack.push(current.rightChild);
                }
            }else{
                System.out.printf("%d ", current.data);
                stack.pop();
            }
            prev = current;
        }
		System.out.println();
    }
	
	public int getTreeSize(){
        int size = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()){
            Node n = stack.pop();
            size++;
            if(n.rightChild!=null){
                stack.push(n.rightChild);
            }
            if(n.leftChild!=null){
                stack.push(n.leftChild);
            }
        }
        return size;
    }
	
	public boolean isPresentInTree(int data){
		
        Stack<Node> stack = new Stack<>();
        Node current = rootNode;
        boolean bDone = false;
        while (!bDone){
            if(current != null){
                stack.push(current);
                current = current.leftChild;
            }else{
                if(stack.isEmpty()){
                    bDone = true;
                }else{
                    Node n = stack.pop();
                    if(n.data == data){
                        return true;
                    }
                    current = n.rightChild;
                }
            }
        }
        return false;
    }
	
	public void displayTree(){
        Stack<Node> mainStack = new Stack<>();
        mainStack.push(rootNode);
        int spaces = 32;
        boolean bEmptyRow = false;

        while(!bEmptyRow){
            Stack<Node> stack = new Stack<>();
            bEmptyRow = true;
            // left spaces
            for(int i = 0; i < spaces; i++){
                System.out.print(" ");
            }
            while(!mainStack.isEmpty()){
                Node n = mainStack.pop();
                if(n!=null){
                    System.out.print(n.data);
                    stack.push(n.leftChild);
                    stack.push(n.rightChild);
                    if(n.leftChild!=null || n.rightChild!=null){
                        bEmptyRow = false;
                    }
                }else{
                    System.out.print("__");
                    stack.push(null);
                    stack.push(null);
                }

                // right spaces after each element
                for(int i = 0; i < spaces*2-2; i++){
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
            spaces = spaces / 2;
            while(!stack.isEmpty()){
                mainStack.push(stack.pop());
            }
        }
    }
}
