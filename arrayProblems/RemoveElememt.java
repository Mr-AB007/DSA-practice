//Remove element(leetcode) Time Complexity: O(n)
class RemoveElement {

  //Approach : 1 with swaping
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length - 1;  // last index
        int k = 0;

        for (int i = 0; i <= n; i++) { // Iterate till 'n'
            if (nums[i] == val) {
                while (n > i && nums[n] == val) { // Find a non-val element from the end
                    n--;
                }
                if (n > i) { // Swap only if valid
                    swap(nums, i, n);
                    n--; // Reduce n as we have placed val at the end
                }
            }
            if (nums[i] != val) { // Increase count of valid elements
                k++;
            }
        }
        return k;
    }




  //Approach : 2   overwritting nums value 

  public static int removeElement2(int[] nums, int val) {
        int k = 0; // Counter for non-val elements
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) { 
                nums[k] = nums[i]; // Overwrite at index 'k'
                k++; // Increase k for non-val elements
            }
        }
        
        return k; // k is the count of non-val elements
    }

  public static void main(String[] args){
    int nums[] = {3,2,2,3};
    val = 3;
    int k = removeElement2(nums,val);
      
}
