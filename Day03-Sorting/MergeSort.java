public class MergeSort {
    public static void conquer(int arr[], int si, int mid, int ei) {
        int merger[] = new int[ei - si + 1];
        int indx1 = si;
        int indx2 = mid + 1;
        int x = 0;
        // Merging 
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] <= arr[indx2]) {
                merger[x++] = arr[indx1++];
            } else {
                merger[x++] = arr[indx2++];
            }
        }
        // Copy remaining elements from left half
        while (indx1 <= mid) {
            merger[x++] = arr[indx1++];
        }
        // Copy remaining elements from right half, if any
        while (indx2 <= ei) {
            merger[x++] = arr[indx2++];
        }
        // Copy sorted elements back to the original array
        for (int i = 0, j = si; i < merger.length; i++, j++) {
            arr[j] = merger[i];
        }
    }
    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2; // Calculate mid index
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        divide(arr, 0, n - 1);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
