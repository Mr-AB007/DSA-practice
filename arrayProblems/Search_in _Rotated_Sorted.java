/*
LeetCode 33. Search in Rotated Sorted Array

Problem:
There is an integer array nums sorted in ascending order (with distinct values).
Before being passed to your function, nums is possibly rotated at an unknown pivot.

Example:
Original: [0,1,2,4,5,6,7]
Rotated : [4,5,6,7,0,1,2]

Given the rotated array nums and an integer target,
return the index of target if it exists in nums, otherwise return -1.

You must write an algorithm with O(log n) runtime complexity.

Approach:
- Use Binary Search.
- At every iteration, one half of the array is always sorted.
- Check whether the target lies in the sorted half.
- If yes, search in that half.
- Otherwise, search in the other half.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {

        // Initialize search boundaries
        int start = 0;
        int end = nums.length - 1;

        // Perform Binary Search
        while (start <= end) {

            // Find the middle index safely
            int mid = start + (end - start) / 2;

            // Target found
            if (nums[mid] == target)
                return mid;

            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {

                // Target lies within the sorted left half
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                }
                // Target lies in the right half
                else {
                    start = mid + 1;
                }

            }
            // Otherwise, the right half is sorted
            else {

                // Target lies within the sorted right half
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                }
                // Target lies in the left half
                else {
                    end = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}
