import java.util.Arrays;

class QuickSort {
    public static void main(String args[]) {
    
        int[] arr = {23, 6, 9, 2, 4, 6, 8, 0, 1};
        
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        // Calling the QuickSort function
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    /**
     * QuickSort function that sorts an array using the divide-and-conquer approach.
     * @param arr   The input array
     * @param start The starting index of the current partition
     * @param end   The ending index of the current partition
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;  // Base case: return if the partition size is 1 or less
        }
        
        // Partition the array and get the pivot index
        int pivot = partition(arr, start, end);

        // Recursively sort elements before the pivot
        quickSort(arr, start, pivot - 1);

        // Recursively sort elements after the pivot
        quickSort(arr, pivot + 1, end);
    }

    /**
     * Partition function using Lomuto's partitioning scheme.
     * It selects the last element as the pivot and rearranges the array so that:
     * - Elements smaller than pivot are on the left
     * - Elements greater than pivot are on the right
     * @param arr   The input array
     * @param start The starting index of the partition
     * @param end   The ending index of the partition (pivot element)
     * @return The index of the pivot after partitioning
     */
    public static int partition(int[] arr, int start, int end) {
        int pivotValue = arr[end]; // Choosing the last element as the pivot
        int i = start - 1;  // Pointer for the smaller element position

        // Traverse through the array and swap elements if they are smaller than the pivot
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivotValue) {
                i++;  // Move the smaller element pointer forward
                swap(arr, i, j); // Swap the elements
            }
        }

        // Swap the pivot element with the element at (i+1) to place it in the correct position
        swap(arr, i + 1, end);

        // Return the final index of the pivot
        return i + 1;
    }

    /**
     * Swap function to exchange two elements in the array.
     * @param arr The input array
     * @param i   First index
     * @param j   Second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
