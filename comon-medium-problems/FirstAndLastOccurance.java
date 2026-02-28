/*
Problem: Find First and Last Position of Element in Sorted Array leetCode; 34

Given a sorted integer array nums (sorted in non-decreasing order) 
and an integer target, return the starting and ending position 
of the given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums.length == 0)
            return res;

        int left = 0, right = nums.length - 1;

        // Find first occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1;   // move left to find earlier occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        // Find last occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                res[1] = mid;
                left = mid + 1;    // move right to find later occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
