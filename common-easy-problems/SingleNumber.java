class SingleNumber {
    public static int singleNumber(int[] nums) {
        //brute force
        
        // Arrays.sort(nums);
        // int left = 0;
        // for(int i = 1;i<nums.length - 1; i++){
        //     if(nums[left] == nums[i]){
        //         left = i + 1;
        //         i = i+1;
        //     }
                
        // }
        // return nums[left];
      
        int result = 0; // Initialize result with 0

        // XOR all elements
        for (int num : nums) {
            result ^= num; // Perform XOR
        }

        return result; // The single non-duplicate number remains
    
    }
public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2}; // Example input
        System.out.println(findSingleNumber(nums)); // Output: 4
    }
}

/*
🛠️ **How XOR Works in This Problem (Step-by-Step Calculation)**

Given array: [4, 1, 2, 1, 2]

1️⃣ Start with result = 0
2️⃣ Perform XOR operation for each number:

   Step 1: 0  ^ 4  = 4  
   Step 2: 4  ^ 1  = 5  
   Step 3: 5  ^ 2  = 7  
   Step 4: 7  ^ 1  = 6  (1 cancels out)  
   Step 5: 6  ^ 2  = 4  (2 cancels out) ✅  

Final result: 4 (which is the single number)

💡 **Why does this work?**
   - XOR of a number with itself is 0:  `a ^ a = 0`
   - XOR of a number with 0 is the number itself:  `a ^ 0 = a`
   - XOR is **commutative** and **associative**, so order does not matter.

📌 **Time Complexity:** O(n) (We iterate through the array once)  
📌 **Space Complexity:** O(1) (Only one variable is used)
*/
