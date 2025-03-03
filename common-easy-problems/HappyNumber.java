//Happy Number problem
public class HappyNumber {

    /**
     * Recursively determines whether a number is happy.
     * @param n - the input number
     * @return true if n is a happy number, false otherwise
     * Time: O(log n)
     * Space: O(log n)
     */
    public boolean isHappy(int n) {
        // Base case: If n becomes 1, it is a happy number
        if (n == 1 || n == 7) return true; 
        
        // If n is a single-digit number and not 1 or 7, it is unhappy
        else if (n < 10) return false;
        
        else {
            int sum = 0;
            // Calculate the sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            // Recur with the new sum
            return isHappy(sum);
        }
    }

  /**
     * Iterative method to determine whether a number is happy using two-pointer approach.
     * @param n - the input number
     * @return true if n is a happy number, false otherwise
     * Time: O(log n)
     * Space: O(1)
  */
    public boolean isHappyIterative(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getSumOfSquares(slow);    // Move slow by one step
            fast = getSumOfSquares(getSumOfSquares(fast)); // Move fast by two steps

            // If fast reaches 1, the number is happy
            if (fast == 1) return true;

        } while (slow != fast); // Detect cycle

        // If slow meets fast and it's not 1, it's an unhappy number
        return false;
    }

    /**
     * Helper function to compute the sum of squares of digits of n.
     */
    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19)); // Output: true
        System.out.println(hn.isHappyIterative(2));  // Output: false
    }
}
