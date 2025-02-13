public class FibonacciPerformanceTest {
    // Recursive Fibonacci - O(2ⁿ)
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci - O(N)
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = { 10, 30, 50 }; // Test for different Fibonacci numbers

        System.out.println("Comparing Recursive vs Iterative Fibonacci:");
        System.out.println("N  | Recursive (ms) | Iterative (ms)");
        System.out.println("------------------------------------");

        for (int N : testCases) {
            // Measure Recursive Fibonacci Time
            long start = System.nanoTime();
            if (N <= 40) { // Prevent long execution time for large N
                fibonacciRecursive(N);
            }
            long recursiveTime = System.nanoTime() - start;

            // Measure Iterative Fibonacci Time
            start = System.nanoTime();
            fibonacciIterative(N);
            long iterativeTime = System.nanoTime() - start;

            // Print results in milliseconds
            System.out.println(N + " | " + (recursiveTime / 1e6) + " ms | " + (iterativeTime / 1e6) + " ms");
        }
    }
}
