class Solution {
    /*
     * LeetCode Problem 287: Find the Duplicate Number
     *
     * Given an array nums containing n + 1 integers where each integer is in the range [1, n] inclusive,
     * there is only one repeated number in nums. Return this repeated number.
     *
     * Example:
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Finding the intersection point in the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
