/*
Sum of Digits of String After Convert
*/
class  SumOfDigitOfString{
    public static int getLucky(String s, int k) {
        int sum = 0;
        
        // Step 1: Convert each character to its corresponding position in the alphabet
        // (a -> 1, b -> 2, ..., z -> 26) and sum their digits
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 96; // Convert char to integer (1-26)
            
            // Sum the digits of this number
            while (n > 0) {
                sum += n % 10; // Extract the last digit and add it to sum
                n = n / 10;    // Remove the last digit
            }
        }

        // Step 2: Repeat the digit sum process k times
        for (int i = k - 1; i > 0; i--) { // k-1 since first conversion is already done
            int n = sum;
            sum = 0;
            
            // Compute the sum of digits again
            while (n > 0) {
                sum += n % 10; // Extract last digit and add to sum
                n = n / 10;    // Remove the last digit
            }
        }

        // Return the final transformed sum
        return sum;
    }
    public static void main(String[] args){
      
    System.out.println(sol.getLucky("leetcode", 2)); // Output: 6

}
}
