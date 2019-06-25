package BinarySearchTree;

public class BST {
    // Root Node
    private Node root;

    // Helper methods
    // 1. Insert new node
    public void insert(int key, String val){
        // Create a Node instance
        Node n = new Node(key, val);

        // If root is null, means there is no tree. Make n the root node
        if(root == null){
            root = n;
        }else{
            // Create a current node and assign root to it
            Node current = root;
            Node parent; // Parent node of current node

            while(true){
                parent = current; // Assign parent to current.
                if(key < current.key){ // Check whether inserting key is less than the key of current node
                    current = current.leftChild; // if true, move current to left of the tree
                    if(current == null){
                        parent.leftChild = n; // move until parent is leaf. then assign new node to it.
                        return;
                    }
                }else{
                    // for greater than case
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild  = n;
                        return;
                    }
                }
            }
        }
    }

    public Node findMin(){
        Node current = root;
        Node parent = null;

        while (current!=null){
            parent = current;
            current = current.leftChild;
        }
        return parent;
    }

    public Node findMax(){
        Node current = root;
        Node parent = null;

        while (current!=null){
            parent = current;
            current = current.rightChild;
        }
        return parent;
    }

    public boolean remove(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        // Searching to find the node with the key to delete
        while (current.key != key){
            parent = current;
            if(key < current.key){
                current = current.leftChild;
                isLeftChild = true;
            }else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if(current == null){
                return false; // node is not present
            }
        }
        // at this point we have found the node
        Node nodeToDelete = current;

        // node is leaf
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if(nodeToDelete == root){
                root = null;
            } else if(isLeftChild){
                parent.leftChild = null;
            } else{
                parent.rightChild = null;
            }
        }
        // node has a one child that is on the left
        else if(nodeToDelete.rightChild == null){
            if(nodeToDelete == root){
                root = nodeToDelete.leftChild;
            }else if(isLeftChild){
                parent.leftChild = nodeToDelete.leftChild;
            }else{
                parent.rightChild = nodeToDelete.leftChild;
            }
        }
        // node has a one child that is on the left
        else if(nodeToDelete.leftChild == null){
            if(nodeToDelete == root){
                root = nodeToDelete.rightChild;
            }else if(isLeftChild){
                parent.leftChild = nodeToDelete.rightChild;
            }else{
                parent.rightChild = nodeToDelete.rightChild;
            }
        }
        // node has both children
        // find the min from the set of nodes that are larger than delete node
        // then replace the references
        else{
            // to find the min from the set of larger nodes,
            // first take right from root then go all the way down to left
            Node successor = getSuccessor(nodeToDelete);
            // now connect nodeToDelete parent to successor
            if(nodeToDelete == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successor = nodeToDelete;
        Node parent =  nodeToDelete;
        Node current = nodeToDelete.rightChild;

        while (current != null){
            parent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor!=nodeToDelete.rightChild){
            parent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }
}
