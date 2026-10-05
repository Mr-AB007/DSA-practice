class Solution {

    // LeetCode 268 - Missing Number
    // Approach 1: HashSet
    /*
    public int missingNumber(int[] nums) {
        int n = nums.length;

        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return n;
    }
    */

    // LeetCode 268 - Missing Number
    // Approach 2: Sum Formula
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int sum = IntStream.of(nums).sum();

        return expectedSum - sum;
    }
}
