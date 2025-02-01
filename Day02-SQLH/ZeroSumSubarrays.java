import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        
        // Use HashMap to store cumulative sum and indices
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize with sum 0 at index -1 to handle cases where subarray starts from index 0
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If this sum was seen before, it means subarrays exist with zero sum
            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add the current index to the list of indices where this sum appears
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(nums);

        for (int[] pair : subarrays) {
            System.out.println("Subarray found from index " + pair[0] + " to " + pair[1]);
        }
    }
}