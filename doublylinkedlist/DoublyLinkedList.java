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

}
