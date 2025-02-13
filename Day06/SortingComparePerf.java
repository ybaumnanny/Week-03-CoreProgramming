import java.util.Arrays;
import java.util.Random;

public class SortingComparePerf {
    // Bubble Sort - O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if already sorted
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < n1) arr[k++] = leftArray[i++];
        while (j < n2) arr[k++] = rightArray[j++];
    }

    // Quick Sort - O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Performance Comparison
    public static void compareSortingPerformance(int N) {
        Random rand = new Random();
        int[] original = new int[N];

        // Generate random values
        for (int i = 0; i < N; i++) original[i] = rand.nextInt(N * 10);

        // Copy arrays for fair comparison
        int[] arr1 = Arrays.copyOf(original, N);
        int[] arr2 = Arrays.copyOf(original, N);
        int[] arr3 = Arrays.copyOf(original, N);

        // Measure Bubble Sort Time
        long start = System.nanoTime();
        bubbleSort(arr1);
        long bubbleTime = System.nanoTime() - start;

        // Measure Merge Sort Time
        start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        long mergeTime = System.nanoTime() - start;

        // Measure Quick Sort Time
        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        long quickTime = System.nanoTime() - start;

        // Print results in milliseconds
        System.out.printf("%12d | %18.6f ms | %18.6f ms | %18.6f ms%n",
                          N, bubbleTime / 1e6, mergeTime / 1e6, quickTime / 1e6);
    }

    public static void main(String[] args) {
        int datasetSizes[] = {1000, 10000, 100000};

        System.out.println("Comparing Sorting Algorithms:");
        System.out.println("Dataset Size | Bubble Sort (ms)  | Merge Sort (ms)   | Quick Sort (ms)");

        for (int N : datasetSizes) {
            compareSortingPerformance(N);
        }
    }
}
