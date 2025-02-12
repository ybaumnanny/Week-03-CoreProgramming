import java.util.*;
public class MissingAndSearch {
    public static int findMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];

        for (int num : arr) 
            if (num > 0 && num <= n) visited[num] = true;

        for (int i = 1; i <= n; i++) 
            if (!visited[i]) return i;
        return n + 1;
    }
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findMissingPositive(arr));

        int[] sortedArr = {1, 2, 3, 4, 5, 6};
        int target = 4;
        System.out.println("Index of target: " + binarySearch(sortedArr, target));
    }
}
