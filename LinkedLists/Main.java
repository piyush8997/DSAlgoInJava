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

        System.out.println("Remove from start");
        while (!linkedList.isEmpty()){
            System.out.println(linkedList.removeFromStart());
        }

        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(50);
        linkedList.insertAtStart(8888);
        linkedList.insertAtStart(9999);

        System.out.println("\nRemove from end");
        while (!linkedList.isEmpty()){
            System.out.println(linkedList.removeFromEnd());
        }

    }
}
