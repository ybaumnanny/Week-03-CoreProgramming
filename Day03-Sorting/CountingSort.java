import java.util.Arrays;
public class CountingSort {
    public static void countingSort(int[] arr, int minAge, int maxAge) {
        int range = maxAge - minAge + 1; // Range of ages (10 to 18 -> 9 values)
        int[] count = new int[range]; // Count array to store frequency
        int[] output = new int[arr.length]; // Output array for sorted values
        // Count occurrences of each age
        for (int age : arr) {
            count[age - minAge]++;
        }
        // Compute cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Place elements in the correct position
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - minAge] - 1] = arr[i];
            count[arr[i] - minAge]--;
        }
        // Copy sorted elements to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 14, 10, 18, 16, 13, 12, 11, 15};

        System.out.println("Original Ages: " + Arrays.toString(studentAges));

        countingSort(studentAges, 10, 18);

        System.out.println("Sorted Ages: " + Arrays.toString(studentAges));
    }
}
