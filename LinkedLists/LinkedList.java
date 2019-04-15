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

    void removeFromEnd() {
        Node prev = null;
        Node _head = head;
        while (_head.next != null) {
            prev = _head;
            _head = _head.next;
        }
        if (prev == null) {
            head = null;
            current = null;
            System.out.println("\nNULL");
        } else {
            prev.next = null;
            current = prev;
        }
    }

    void insertAtStart(int data) {
        Node n = new Node();
        n.data = data;
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    void removeFromStart() {
        if (head.next != null) {
            head = head.next;
        } else {
            head = null;
            current = null;
        }
    }

    boolean isEmpty() {
        return head == null;
    }
}
