package sorting;
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        int[] a = {2, 3,17, 15, 9};
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Initialize swapped to false for each pass
            
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true; // Set swapped to true since a swap occurred
                }
            }
            if (!swapped) {
                // If no swaps were made, the array is already sorted
                break;
            }
        }
        Arrays.stream(a).forEach(System.out::println);
    }
}
