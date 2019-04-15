class LinkedList {
    private Node head, current;

    LinkedList() {
        head = null;
        current = null;
    }

    void insertAtEnd(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (isEmpty()) {
            head = n;
        } else {
            current.next = n;
        }
        current = n;
    }

    void printList() {
        Node _head = head;
        System.out.println();
        while (_head != null) {
            System.out.printf("[%d]", _head.data);
            _head = _head.next;
        }
    }

    int removeFromEnd() {
        Node prev = null;
        Node _head = head;
        int d = -1;
        if(isEmpty()){
            System.out.println("Already empty");
            return d;
        }
        while (_head.next != null) {
            prev = _head;
            _head = _head.next;
        }
        if (prev == null) {
            d = head.data;
            head = null;
            current = null;
        } else {
            d = _head.data;
            prev.next = null;
            current = prev;
        }

        return d;
    }

    void insertAtStart(int data) {
        Node n = new Node();
        n.data = data;
        if (isEmpty()) {
            head = n;
            current = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    int removeFromStart() {
        if(isEmpty()){
            System.out.println("Already empty");
           return -1;
        }

        int data = -1;
        if (head.next != null) {
            data = head.data;
            head = head.next;
        } else {
            data = head.data;
            head = null;
            current = null;
        }
        return data;
    }

    boolean isEmpty() {
        return head == null;
    }

}
