import java.util.Arrays;
public class BubbleSort {
    public static void main(String[]args) {
        //initializing an array
        int arr[] = {78, 82, 73, 91, 62};
            int n = arr.length;
        System.out.println("Original Marks :" + Arrays.toString(arr));
//Bubble sort
        for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        //Swapping
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println("Sorted Marks :" + Arrays.toString(arr));
        }
    }