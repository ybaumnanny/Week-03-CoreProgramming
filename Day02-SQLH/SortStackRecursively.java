import java.util.Stack;
class SortStackRecursively {
    //  sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Pop the top element
            sortStack(stack); // Recursively sort the remaining stack
            insertInSortedOrder(stack, temp); // Insert the popped element in the correct position
        }
    }
    // insert an element into a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop(); // Remove top element
            insertInSortedOrder(stack, element); // Recursive call
            stack.push(temp); // Restore the removed element
        }
    }
    // print stack elements
    public static void printStack(Stack<Integer> stack) {
        for (int elem : stack) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
       public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}