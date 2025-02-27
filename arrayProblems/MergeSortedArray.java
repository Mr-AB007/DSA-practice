// withou creatinf a new array (in place merge on nums1)
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Pointer for last initialized element in nums1
        int j = n - 1;  // Pointer for last element in nums2
        int k = m + n - 1;  // Pointer for the last position in nums1

        // Merge in reverse order (starting from the largest elements)
        while (j >= 0) {  
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];  // Move nums1[i] to correct position
                i--;
            } else {
                nums1[k] = nums2[j];  // Move nums2[j] to correct position
                j--;
            }
            k--; // Move merge pointer backwards
        }
    }
}
