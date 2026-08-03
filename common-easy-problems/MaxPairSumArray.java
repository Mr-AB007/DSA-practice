/*
LeetCode 2815. Max Pair Sum in an Array

Problem:
You are given an integer array nums.

A pair of numbers is considered valid if both numbers have the same
largest digit. The largest digit of a number is the maximum digit
present in its decimal representation.

Return the maximum possible sum of a valid pair.
If no such pair exists, return -1.

Example:
Input: nums = [51, 71, 17, 24, 42]
Output: 88

Explanation:
- Largest digit of 71 = 7
- Largest digit of 17 = 7
They form a valid pair with sum = 71 + 17 = 88.

Approach:
1. Compute the largest digit of every number.
2. Use a HashMap where:
      key   -> largest digit (0-9)
      value -> largest number seen so far with that largest digit.
3. If another number with the same largest digit is found:
      - Update the answer using the stored number.
      - Keep the larger of the two numbers in the map.
4. Return the maximum pair sum.

Time Complexity: O(n * d)
    n = number of elements
    d = number of digits (at most 10)
    => Overall O(n)

Space Complexity: O(10) ≈ O(1)
*/

class Solution {
    public int maxSum(int[] nums) {

        // Stores:
        // Key   -> Largest digit
        // Value -> Largest number encountered with that largest digit
        Map<Integer, Integer> map = new HashMap<>();

        // Stores the maximum valid pair sum
        int maxS = -1;

        // Traverse every number in the array
        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];
            int maxDigit = 0;

            // Find the largest digit of the current number
            while (n > 0) {
                maxDigit = Math.max(maxDigit, n % 10);
                n /= 10;
            }

            int num = nums[i];

            // If another number with the same largest digit exists
            if (map.containsKey(maxDigit)) {

                // Update the maximum pair sum
                maxS = Math.max(maxS, map.get(maxDigit) + num);

                // Store the larger number for future comparisons
                map.put(maxDigit, Math.max(map.get(maxDigit), num));

            } else {

                // First number with this largest digit
                map.put(maxDigit, num);
            }
        }

        return maxS;
    }
}
