import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = { 1000, 100_000, 1_000_000 };
        Random random = new Random();
        for (int size : sizes) {
            System.out.println("Data size: " + size);
            // initialize array,hashmap and treeset
            int array[] = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10);
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);

            }
            // pick an element to search
            int searchElement = array[size / 2];
            // start time
            long start = System.nanoTime();
            boolean foundInArray = linearSearch(array, searchElement);
            // end time
            long end = System.nanoTime();
            System.out.println("Search time in Array: " + (end - start) / 1_000_000.0 + "ms");

            start = System.nanoTime();
            boolean foundInHashset = hashSet.contains(searchElement);
            end = System.nanoTime();
            System.out.println("Search time in Hashset: " + (end - start) / 1_000_000.0 + "ms");

            start = System.nanoTime();
            boolean foundInTreeset = treeSet.contains(searchElement);
            end = System.nanoTime();
            System.out.println("Search time in TreeSet: " + (end - start) / 1_000_000.0 + "ms");
        }

    }

    // method to search array element
    private static boolean linearSearch(int array[], int key) {
        for (int num : array) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }
}