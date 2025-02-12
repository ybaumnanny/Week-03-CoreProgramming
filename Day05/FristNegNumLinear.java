public class FristNegNumLinear{
    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, -5, 6, -7, 8, -9, 10};// array of integers
        int n = arr.length;// length of array
        int i = 0;
        while (i < n) {// loop to iterate through the array
            if (arr[i] < 0) {
                System.out.println("First negative number is " + arr[i]);// print statement
                break;
                }
            i++;// incrementing the value of i
            }
        }
    }