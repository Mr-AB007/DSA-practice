import java.util.HashSet;
import java.util.Set;

class LongestFabonacciSeq {
    public int lenLongestFibSubseq(int[] arr) {
        // Use a HashSet for quick lookups (O(1) search time)
        Set<Integer> index = new HashSet<>();
        for (int n : arr) {
            index.add(n);
        }

        int max = 2; // Stores the maximum length of a Fibonacci-like subsequence
        
        // Outer loop: Selects the first element of the sequence
        for (int i = 0; i < arr.length - max; i++) {

            // Optimization: Break early if extending the sequence is impossible
            if (arr[i] + arr[i + 1] > arr[arr.length - 1])
                break;

            // Inner loop: Selects the second element of the sequence
            for (int j = i + 1; j < arr.length - max + 1; j++) {

                if (arr[j] + arr[j - 1] > arr[arr.length - 1])
                    break;

                // Initialize first two elements of the sequence
                int n2 = arr[i], n1 = arr[j]; // First and second numbers
                int len = 2; // Start with length 2

                // Extend sequence without using an extra swap variable
                while (index.contains(n1 + n2)) {
                    n1 = n1 + n2; // New Fibonacci number
                    n2 = n1 - n2; // Update previous number without extra variable
                    len++;
                }

                max = Math.max(max, len); // Update max length if current sequence is longer
            }
        }
        
        // If max length is still 2, return 0 (no valid sequence found)
        return max < 3 ? 0 : max;
    }
//##################################################
  // Simple bruteForce Approach
public int lenLongestFibSubseq1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;
        int n = arr.length;

        for (int num : arr) {
            set.add(num);
        }

        // Try every possible pair (arr[i], arr[j]) as the first two elements of the Fibonacci sequence
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j];
                int length = 2;  // A Fibonacci-like sequence must have at least two elements
                
                while (set.contains(a + b)) {
                    int temp = a + b;
                    a = b;
                    b = temp;
                    length++;
                }

                if (length > 2) {  // Only update maxLength if it's a valid Fibonacci sequence
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
  
}


