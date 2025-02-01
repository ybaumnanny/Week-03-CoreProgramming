import java.util.HashMap;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        // Use an appropriate initial capacity to minimize resizing overhead
        HashMap<Integer, Integer> numMap = new HashMap<>((int) (nums.length / 0.75) + 1);
        for (int num : nums) {
            int complement = target - num;
            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                return true;
            }
            // Store the current number in the map
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;
        System.out.println(hasPairWithSum(nums, target)); // Output: true
    }
}
