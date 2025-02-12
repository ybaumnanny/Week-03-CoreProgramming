public class FirstLastOccurrenceBinary {
    public static int findFirst(int[] arr, int target) {
        int start = 0, end = arr.length - 1, first = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                first = mid; // Found target, move left to find first occurrence
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                last = mid; // Found target, move right to find last occurrence
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        System.out.println("First occurrence" + first);
        System.out.println("Last occurrence" + last);   
        }
    }