//Minimum Value to Get Positive Step by Step Sum leetcode:- 1413
class MinimumValue {
    public int minStartValue(int[] nums) {
        // Initialize sum and minimum value
        int sum = 0;          // current running sum
        int minSum = 0;       // minimum running sum we encounter

        // Traverse the array
        for (int num : nums) {
            sum += num;       // update running sum
            minSum = Math.min(minSum, sum);  // update minSum if current sum is smaller
        }

        // After traversal, to make sure step-by-step sum is always positive,
        // the starting value must at least offset the minimum dip.
        // So startingValue = 1 - (minimum sum encountered) if minSum = -5 then 1-(-5) = 6

        return 1 - minSum;

        
    }
}
