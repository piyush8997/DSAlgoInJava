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

        System.out.println("\n"+linkedList.deleteNode(40).data + " is removed");
        linkedList.printList();

        System.out.println("\n"+linkedList.deleteNode(888).data + " is removed");
        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();

        linkedList.insertAfter(999,1111);
        linkedList.printList();

        System.out.printf("\n[%d] deleted",linkedList.deleteFromEnd());
        linkedList.printList();

        System.out.println("\n"+linkedList.deleteNode(999).data + " is removed");
        linkedList.printList();
    }
}
