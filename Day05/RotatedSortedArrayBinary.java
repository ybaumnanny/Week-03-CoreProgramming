public class RotatedSortedArrayBinary {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2; // Avoids integer overflow
    
                if (arr[mid] > arr[right]) {
                    left = mid + 1; // Smallest element is in the right half
                } else {
                    right = mid; // Smallest element is in the left half (including mid)
                }
            }
    
            return left; // The index of the smallest element
        }
        public static void main(String[] args) {
            int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
            int index = findRotationPoint(arr);
            System.out.println("Index of the smallest element (rotation point): " + index);
            System.out.println("Smallest element: " + arr[index]);
        }
    }
    


