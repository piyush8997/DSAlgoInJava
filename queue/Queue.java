package queue;

public class Queue {
    private Node start, end;

    Queue() {
        start = null;
        end = null;
    }

    void enQueue(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (isEmpty()) {
            start = n;
        } else {
            end.next = n;
        }
        end = n;
        System.out.println("EnQueue :: "+data);
    }

    int deQueue() {
        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        int d = start.data;
        start = start.next;
        System.out.println("DeQueue :: "+d);
        return d;
    }

    void printQueue() {
        Node s = start;
        System.out.print("\nQueue :: ");
        while (s!=null){
            System.out.print(" "+s.data);
            s = s.next;
        }
        System.out.println();
    }

    boolean isEmpty() {
        return start == null;
    }

    int showStart(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        return start.data;
    }

    int showEnd(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        return end.data;
    }
}
