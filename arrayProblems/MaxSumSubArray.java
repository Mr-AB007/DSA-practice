// LeetCode Problem: 53. Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) 
// which has the largest sum and return its sum.

// --------------------------
// ✅ Kadane’s Algorithm Intuition:
// At every index, we ask: Should I continue the previous subarray OR start fresh from here?
// - sum = max(current element, current element + previous sum)
// - maxsum = max(maxsum so far, current sum)
// --------------------------

class MaxSumSubArray {

  // --------------------------
// ✅ Kadane’s Algorithm Intuition:
// At every index, we ask: Should I continue the previous subarray OR start fresh from here?
// - sum = max(current element, current element + previous sum)
// - maxsum = max(maxsum so far, current sum)
// --------------------------
    public int maxSubArray(int[] nums) {
        
        int maxsum = nums[0];
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++){
            // sum += nums[i];
            
            // sum = nums[i] > sum ? nums[i] : sum; 

            // maxsum = maxsum < sum ? sum : maxsum;

            //above code equivalent to below

            // Either start a new subarray from current element,
            // or continue adding it to previous subarray
            sum = Math.max(nums[i], sum + nums[i]);

            // Update maxsum if current sum is greater
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}
