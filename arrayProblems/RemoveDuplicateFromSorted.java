import java.util.Arrays;

/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Time:- O(n) array traveasl
Space:- O(1) no extra space used
*/

class RemoveDuplicateFromSorted {
   public int removeDuplicates(int[] nums) {
    // Edge case: If the array is empty, return 0 as there are no elements.
    if (nums.length == 0)
        return 0;

    int k = 0; // Pointer to track the position of unique elements

    // Iterate through the array starting from the second element
    for (int i = 1; i < nums.length; i++) {
        // If the current element is different from the last unique element at nums[k]
        if (nums[k] != nums[i]) {
            nums[++k] = nums[i]; // Move k forward and store the unique element
        }
    }

    return k + 1; // The number of unique elements (since k is 0-based)
}

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 1, 2, 3, 3, 4};
        System.out.println("Original array: " + Arrays.toString(nums));

        int uniqueCount = solution.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + uniqueCount);

        // Print the modified array up to the unique count
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, uniqueCount)));
    }
}
