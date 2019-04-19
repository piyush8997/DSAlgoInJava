package queue;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);

        q.printQueue();

        q.deQueue();
        q.deQueue();

        q.enQueue(5555);
        q.printQueue();

        q.deQueue();
        q.deQueue();

        q.printQueue();

        System.out.println("Is Empty? "+q.isEmpty());
        q.enQueue(4444);
        System.out.println("Start :: "+q.showStart());
        System.out.println("End :: "+q.showEnd());
    }
}
