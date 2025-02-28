import java.util.HashSet;
import java.util.Set;

/*
Outer loop (i): Runs O(N)
Inner loop (j): Runs O(N)
While loop (extending sequence) : O(log M)

Total :- O(N² log M)
*/


//using golden ratio brute force approach
class LongestFabonacciSeq {
   public int lenLongestFibSubseq(int[] arr) {
        // Use a HashSet to store the array elements for quick lookup (O(1) search time)
        Set<Integer> index = new HashSet<>();
        for (int n : arr) {
            index.add(n);
        }

        int max = 2; // Stores the maximum length of any found Fibonacci-like sequence
        
        // Outer loop: Selects the first element of the sequence
        for (int i = 0; i < arr.length - max; i++) {

            // Optimization: Break early if further sequences cannot be extended
            // Using an approximation based on the Golden Ratio (1.618) to estimate Fibonacci growth
            //if max = 5 then F0, F1, F2, F3, F4   (5 elements, but only 4 steps) F1 = F0*1.618
            if (arr[i] * Math.pow(1.618, max - 1) > arr[arr.length - 1])
                break;

            // Inner loop: Selects the second element of the sequence
            for (int j = i + 1; j < arr.length - max + 1; j++) {

                // Similar early termination check(max - 2) because a[i] is first elente of seq and a[j] is 2nd so n-2;
                if (arr[j] * Math.pow(1.618, max - 2) > arr[arr.length - 1])
                    break;

                // Initialize first two elements of the sequence
                int n2 = arr[i]; // First number
                int n1 = arr[j]; // Second number
                int len = 2; // Start with length 2 since we have two numbers

                // Extend the sequence by checking if the sum exists in the array
                while (index.contains(n1 + n2)) {
                    int temp = n1 + n2; // Calculate next Fibonacci number
                    n2 = n1; // Move forward: Second number becomes first
                    n1 = temp; // New Fibonacci number becomes second
                    len++; // Increase sequence length
                }

                // Update max length if the current sequence is longer
                if (len > max)
                    max = len;
            }
        }
        
        // If max length remains 2, it means no valid Fibonacci-like sequence was found
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


