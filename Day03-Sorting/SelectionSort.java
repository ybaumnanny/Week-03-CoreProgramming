import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update index of minimum element
                }
            }
            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] scores = {85, 78, 92, 66, 88};

        System.out.println("Original Scores: " + Arrays.toString(scores));

        selectionSort(scores);

        System.out.println("Sorted Scores: " + Arrays.toString(scores));
    }
}
