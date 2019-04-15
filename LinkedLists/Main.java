public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(50);

        linkedList.insertAtStart(8888);
        linkedList.insertAtStart(9999);

        linkedList.printList();

        linkedList.removeFromEnd();
        linkedList.printList();

        linkedList.removeFromStart();
        linkedList.printList();

        linkedList.insertAtEnd(5555);
        linkedList.printList();

        System.out.println("\nIs list empty? "+linkedList.isEmpty());
    }
}
