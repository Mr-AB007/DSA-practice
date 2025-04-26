class SubarraysDivByK {
    // HashMap Version
    public int subarraysDivByK_HashMap(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize for remainder 0

        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k; // Handle negative remainders

            count += map.getOrDefault(mod, 0); // If same remainder seen before, add its frequency
            map.put(mod, map.getOrDefault(mod, 0) + 1); // Update the frequency
        }

        return count;
    }

    // Array Version (Optimized)
    public int subarraysDivByK_Array(int[] nums, int k) {
        int[] map = new int[k]; // Similar to HashMap<Integer, Integer>, but fixed size
        map[0] = 1;             // Initialize remainder 0 with frequency 1

        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (mod < 0) mod += k; // Make sure remainder is positive

            count += map[mod];   // Same as map.getOrDefault(mod, 0)
            map[mod] += 1;       // Same as map.put(mod, map.getOrDefault(mod, 0) + 1)
        }

        return count;
    }
}
