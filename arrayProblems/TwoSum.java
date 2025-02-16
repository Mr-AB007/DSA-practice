import java.util.HashMap;  // Import HashMap for storing indices
import java.util.Arrays;   // Import Arrays for array-to-string conversion

class TwoSumArray {
    // Method to find two indices whose sum equals the target
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  // Create a HashMap to store {value, index}

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Calculate required complement

            // If complement exists in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};  // Return stored index first
            }

            // Store the current number and its index in the map
            map.put(nums[i], i);
        }

        // Return empty array if no solution is found (avoiding null return)
        return new int[]{};
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {2, 7, 45, 56};  // Input array
        int target = 9;  // Target sum

        // Call the twoSum method and print the result
        System.out.println(Arrays.toString(twoSum(nums, target)));  // Expected output: [0, 1]
    }
}


 
