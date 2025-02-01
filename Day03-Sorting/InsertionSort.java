public class InsertionSort {
    public static void main(String[] args) {
        //array of ids
        int arr[] = { 209,202,213,204,209,225} ;
        int n = arr.length;
        // Insertion sort
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                //swapping done here
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        //print satement
        System.out.print("Sorted Ids :");
        for(int i =0;i <arr.length; i++){
          System.out.print( arr[i]+ "  ");
    //      printArray(arr);
    // }
    //  public static void printArray(int[] arr) {
    //      for (int i : arr) {
    //          System.out.print(i + " ");
    //      }
    //     System.out.println();
    }
}
}