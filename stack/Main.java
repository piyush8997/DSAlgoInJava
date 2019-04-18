package stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.showStack();

        System.out.println("\nPopped item "+stack.pop());
        stack.showStack();
        System.out.println("\nPopped item "+stack.pop());
        stack.showStack();
        System.out.println("\nPopped item "+stack.pop());
        stack.showStack();

        stack.push(777);
        stack.showStack();

        System.out.println("Top of Stack: "+stack.peek());
    }
}
