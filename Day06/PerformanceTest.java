import java.util.Arrays;
import java.util.Random;

public class PerformanceTest {
    // Linear Search - O(N)
    public static int linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // Binary Search - O(log N)
    public static int binarySearch(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoid integer overflow
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int datasetSizes[] = {1000, 10000, 1000000};
        Random random = new Random();

        System.out.println("Dataset Size | Linear Search | Binary Search");
        

        for (int size : datasetSizes) {
            int[] data = new int[size];

            // Generate random values
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }

            int target = random.nextInt(size * 10); // Ensure target falls in range

            // Measure Linear Search Time
            long start = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - start;

            // Sort the array for Binary Search
            Arrays.sort(data);

            // Measure Binary Search Time
            start = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;

            // Print results in milliseconds
            System.out.printf("%12d | %18.6f ms | %18.6f ms%n", size, linearTime / 1e6, binaryTime / 1e6);
        }
    }
}
