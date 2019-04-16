package doublylinkedlist;

class DoublyLinkedList {
    private Node head, cur;

    DoublyLinkedList() {
        head = null;
        cur = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertAtEnd(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (isEmpty()) {
            head = n;
        } else {
            cur.next = n;
            n.prev = cur;
        }
        cur = n;
    }

    int deleteFromEnd() {
        int d = -1;
        if (isEmpty()) {
            System.out.println("Already empty");
            return d;
        }
        Node previous = cur.prev;
        if (previous == null) {
            d = cur.data;
            cur.next = null;
            head = null;
        } else {
            d = cur.data;
            previous.next = null;
            cur = previous;
        }
        return d;
    }

    void insertAtStart(int data) {
        Node n = new Node();
        n.data = data;
        if (isEmpty()) {
            head = n;
            cur = head;
        } else {
            n.next = head;
            n.prev = null;
            head = n;
        }
    }

    void printList() {
        System.out.println();
        Node _head = head;
        while (_head != null) {
            System.out.printf("[%d] ", _head.data);
            _head = _head.next;
        }
    }

    boolean insertAfter(int key, int data) {
        Node _head = head;

        // Search the node with the key
        while (_head.data != key) {
            _head = _head.next;
            if (_head == null) {
                System.out.println("Key not found. Insertion failed");
                return false;
            }
        }

        // Create a new node
        Node n = new Node();
        n.data = data;

        if (_head == cur) { // searched node is the last node
            n.next = null;
            cur = n;
        } else {
            n.next = _head.next;
        }

        n.prev = _head;
        _head.next = n;

        return true;
    }

    Node deleteNode(int key){
        Node _head = head;
        while (_head.data != key){
            _head = _head.next;
            if(_head == null){
                System.out.println("No key found");
                return null;
            }
        }

        if(_head == cur){ // Last node check
            cur = _head.prev;
            _head.prev.next = null;
        }else if(_head == head){ // First node check
            head = _head.next;
        }else {
            _head.prev.next = _head.next;
            _head.next.prev = _head.prev;
        }

        return _head;
    }

}
