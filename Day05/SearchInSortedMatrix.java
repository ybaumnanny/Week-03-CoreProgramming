public class SearchInSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols, col = mid % cols;
            int midElement = matrix[row][col];

            if (midElement == target) return true;
            else if (midElement < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {7, 10, 12},
            {14, 18, 20}
        };
        int target = 10;
        System.out.println("Target found: " + searchMatrix(matrix, target));
    }
}
