package doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.insertAtStart(7777);
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtStart(999);
        linkedList.insertAtStart(888);

        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();
    }
}
