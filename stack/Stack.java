package stack;

public class Stack {
    private Node top;

    Stack(){
        top = null;
    }

    void push(int data){
        Node n = new Node();
        n.data = data;

        if(isEmpty()){
            n.prev = null;
        }else{
            n.prev = top;
        }

        top = n;
        System.out.println("Push "+data);
    }

    int pop(){
        int data = -1;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else {
            data = top.data;
            top = top.prev;
        }
        return data;
    }

    void showStack(){
        Node tmpTop = top;
        System.out.println("\nCurrent Stack");
        while (tmpTop!=null){
            System.out.println(tmpTop.data);
            tmpTop = tmpTop.prev;
        }
        System.out.println();
    }

    int peek(){
       if(isEmpty()){
           System.out.println("Stack is empty");
           return -1;
       }
       return top.data;
    }

    boolean isEmpty(){
        return top == null;
    }
}
