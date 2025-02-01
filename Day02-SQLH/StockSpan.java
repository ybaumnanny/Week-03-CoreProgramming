import java.util.*;
class Ss {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Result array
        Stack<Integer> stack = new Stack<>(); // Stores indices of prices

        for (int i = 0; i < n; i++) {
            // Remove elements that are smaller or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // Calculate span: if stack is empty, span = i + 1 (all previous days were smaller)
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index onto the stack
            stack.push(i);
        }
        return span;
    }
}
public class StockSpan {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Corrected method call using class name
        System.out.println(Arrays.toString(Ss.calculateSpan(prices)));
        // Output: [1, 1, 1, 2, 1, 4, 6]
    }
}