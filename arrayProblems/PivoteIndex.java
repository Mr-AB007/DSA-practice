class PivoteIndex {
    public int pivotIndex(int[] nums) {

      /* Brute- Force 
         Time: O(n^2)
      */

        //int n = nums.length;
        // int lSum = 0;
        // for(int i = 0 ; i < n ; i++){
        //     int pivot = i;
        //     if(i > 0)
        //         lSum += nums[i-1];
        //     int rSum = 0;
        //     for(int j = i+1 ; j< n ; j++){
        //         rSum += nums[j];
        //     }
        //     if(lSum== rSum)
        //         return pivot;

        // }
        // return -1;


      /* Prefix- Sum 
         Time: O(n)
      */
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }

        int lsum = 0;
        for(int i = 0 ; i < n ; i++){
            
            int rsum = sum - lsum - nums[i];
            // At index i,
            // left sum = lsum
            // right sum = total sum - lsum - nums[i]
            // (because nums[i] is not included in either left or right sum)
            // If left sum == right sum, then i is the pivot index
            if (rsum == lsum)
                return i;

            if(rsum == lsum)
                return i;
                
            lsum += nums[i];

        }
        return -1;
    }
        


}
