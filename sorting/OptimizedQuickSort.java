import java.util.Arrays;

class OptimizedQuickSort {
    // Threshold for switching to Insertion Sort when the partition size is small
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public static void main(String[] args) {
        // Sample unsorted array
        int[] arr = {23, 6, 9, 2, 4, 6, 8, 0, 1};

        // Print the unsorted array
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        // Sort the array using optimized QuickSort
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    /**
     * Optimized QuickSort function.
     * - Uses Hoare’s Partitioning for better performance.
     * - Switches to Insertion Sort when partition size is small.
     * - Implements Tail Recursion optimization to reduce stack depth.
     *
     * @param arr   The input array
     * @param low   The starting index
     * @param high  The ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            // Use Insertion Sort for small subarrays to improve performance
            if (high - low < INSERTION_SORT_THRESHOLD) {
                insertionSort(arr, low, high);
                break;
            } else {
                // Partition the array using Hoare's partitioning scheme
                int pivot = hoarePartition(arr, low, high);

                // Tail Recursion Optimization: Sort the smaller partition first
                if (pivot - low < high - pivot) {
                    quickSort(arr, low, pivot);
                    low = pivot + 1;
                } else {
                    quickSort(arr, pivot + 1, high);
                    high = pivot;
                }
            }
        }
    }

    /**
     * Hoare's partitioning scheme for QuickSort.
     * - Selects a good pivot (median-of-three).
     * - Partitions the array around the pivot.
     * - Performs fewer swaps than Lomuto’s partitioning.
     *
     * @param arr   The input array
     * @param low   The starting index
     * @param high  The ending index
     * @return The partition index
     */
    private static int hoarePartition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high); // Select a pivot using Median-of-Three
        int i = low - 1, j = high + 1;

        while (true) {
            // Move left pointer right until an element is found that is greater than pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Move right pointer left until an element is found that is less than pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If pointers have crossed, return the partition index
            if (i >= j) return j;

            // Swap the elements at i and j
            swap(arr, i, j);
        }
    }

    /**
     * Median-of-Three pivot selection.
     * - Chooses the pivot as the median of the first, middle, and last elements.
     * - Helps avoid worst-case behavior in sorted/reversed inputs.
     *
     * @param arr   The input array
     * @param low   The starting index
     * @param high  The ending index
     * @return The median pivot value
     */
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // Ensure arr[low] <= arr[mid] <= arr[high]
        if (arr[mid] < arr[low]) swap(arr, mid, low);
        if (arr[high] < arr[low]) swap(arr, high, low);
        if (arr[high] < arr[mid]) swap(arr, high, mid);

        return arr[mid]; // Return the median value as pivot
    }

    /**
     * Insertion Sort for small subarrays.
     * - Efficient for small-sized partitions.
     * - Works by placing elements in their correct position one by one.
     *
     * @param arr   The input array
     * @param low   The starting index
     * @param high  The ending index
     */
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements to the right until the correct position is found
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // Place key at its correct position
        }
    }

    /**
     * Swap function to exchange two elements in an array.
     *
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
