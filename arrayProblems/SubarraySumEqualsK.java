// Leetcode Problem: Subarray Sum Equals K
// Link: https://leetcode.com/problems/subarray-sum-equals-k/

// Problem Statement:
// Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals to `k`.

// Example:
// Input: nums = [1, 1, 1], k = 2
// Output: 2

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0; // to store total subarrays with sum equal to k
        int prefixSum = 0; // to store running sum

        // HashMap to store frequency of prefix sums
        // freq.get(s) = number of times prefix sum s has occurred so far
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // base case: prefixSum of 0 occurs once initially

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i]; // update running sum

            // If (prefixSum - k) exists in map, then there exists a subarray ending at index i with sum k
            if (freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }

            // Update the frequency map with current prefix sum
            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

/*
Explanation:
- Use a prefix sum approach to calculate running sum.
- At every step, we check if (prefixSum - k) exists in the map:
    - If yes, it means a subarray(s) with sum k ends at current index.
- HashMap helps store how many times each prefixSum has occurred.

Time Complexity: O(n) — One pass through the array and constant-time operations for HashMap.
Space Complexity: O(n) — In the worst case, we store up to n different prefix sums in the HashMap.
*/
