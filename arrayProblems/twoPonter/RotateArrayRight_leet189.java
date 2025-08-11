class Solution {
  //leetcode pronblem 189 ROTATE ARRAY
  //TWO POINTER

  public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Step 1: Normalize k to avoid extra rotations if k > n

        // Step 2: Reverse the last k elements
        // These are the elements that will move to the front after rotation
        // Example: [1, 2, 3, 4, 5, 6, 7] → reverse [5, 6, 7] → [1, 2, 3, 4, 7, 6, 5]
        rev(nums, n - k, n - 1);

        // Step 3: Reverse the first n-k elements
        // These are the elements that will shift to the back
        // Now reverse [1, 2, 3, 4] → [4, 3, 2, 1, 7, 6, 5]
        rev(nums, 0, n - k - 1);

        // Step 4: Reverse the entire array
        // This combines both parts into the final rotated order
        // Final reverse → [5, 6, 7, 1, 2, 3, 4]
        rev(nums, 0, n - 1);
    }

    // Helper method to reverse elements between two indices
    public void rev(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }



  //BRUTE FORCE APPROACH
    public void rotate(int[] nums, int k) {
        int n = nums.length; //7 - 3 = 4

        List<Integer> list = new ArrayList<>();
        int index = 0;
        k = k%n; // for cases is k is bigger n


        for(int i =n-k; i  < n;i++){
            list.add(nums[i]);
        }

        for(int i = 0;i < n-k; i++){
            list.add(nums[i]);
        }
        for(int i =0 ; i < n ; i++){
            nums[i] = list.get(i);
        }

    }
    //3,2,1,7,6,5,4

}
