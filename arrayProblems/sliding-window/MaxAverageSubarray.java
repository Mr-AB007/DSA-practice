/**
 * Problem: Given an array of integers `nums` and an integer `k`, find the maximum average value of any contiguous subarray of length `k`.
 * 
 * Approach:
 * - Calculate the sum of the first `k` elements.
 * - Use a sliding window to calculate the sum of each subsequent subarray of length `k`.
 * - Track the maximum average encountered.
 * 
 * Time Complexity: O(n), where `n` is the length of the array `nums`.
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */

public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double sums = 0;
        for (int i = 0; i < k; i++) {
            sums += nums[i];
        }
        double max_sum = sums / k;

        for (int i = k; i < nums.length; i++) {
            sums += nums[i] - nums[i - k];
            if (sums / k > max_sum) {
                max_sum = sums / k;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        MaxAverageSubarray solution = new MaxAverageSubarray();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Maximum average subarray of length " + k + " is: " + solution.findMaxAverage(nums, k));
    }
}
