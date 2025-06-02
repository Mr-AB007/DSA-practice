/**
 * LeetCode Problem 238: Product of Array Except Self
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to 
 * the product of all the elements of nums except nums[i].
 * 
 * The algorithm must be done without using division and in O(n) time.
 */

class Product_of_Array_Except_Self {

    // ✅ Method 1: Brute Force (O(n^2))
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }

        return answer;
    }

    // ✅ Method 2: Prefix and Suffix product arrays (no division)
    //Prefix-Suffix (O(n), no division)
    public int[] productExceptSelfPrefixSuffix(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Build prefix product array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        // Build suffix product array
        suffix[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            suffix[j] = suffix[j + 1] * nums[j + 1];
        }

        // Multiply prefix and suffix for final result
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }

    // ✅ Method 3: Using division with zero handling
// Division with zero handling (O(n))
    public int[] productExceptSelfWithDivision(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int zeros = 0;
        int zeroIndex = -1;
        int product = 1;

        // Count zeros and calculate product of non-zero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
                zeroIndex = i;
            } else {
                product *= nums[i];
            }
        }

        // If no zeros, divide total product by each element
        if (zeros == 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = product / nums[i];
            }
        }
        // If one zero, only that index gets the product
        else if (zeros == 1) {
            answer[zeroIndex] = product;
        }
        // If more than one zero, all elements remain 0

        return answer;
    }
}
