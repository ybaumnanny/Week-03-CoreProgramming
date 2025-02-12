public class PeakElementBinarySearch{
    public static int findPeakElement(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) // Move towards the peak
            start = mid + 1;
            else end = mid;
        }
        return start;
   }
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 3, 4};
        int index = findPeakElement(arr);
        System.out.println("Peak element: " + arr[index] + " at index " + index);
    }
}
