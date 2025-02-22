package org.anubhav;
import java.math.BigInteger;

public class AddTwoBinary {

public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder(); // To store the final binary sum
    int carry = 0; // Stores carry from the previous addition
    int i = a.length() - 1; // Pointer for the last character of string `a`
    int j = b.length() - 1; // Pointer for the last character of string `b`

    // Loop until all digits are processed or there is a remaining carry
    while (j >= 0 || i >= 0 || carry != 0) {
        int sum = carry; // Start with the carry value from the previous operation
        
        if (i >= 0) // If `a` has remaining digits, add its value
            sum += a.charAt(i--) - '0'; // Convert character to integer (0 or 1)
        
        if (j >= 0) // If `b` has remaining digits, add its value
            sum += b.charAt(j--) - '0'; // Convert character to integer (0 or 1)
        
        carry = sum / 2; // Compute the carry for the next step (1 if sum is 2 or 3)
        sb.append(sum % 2); // Append the current binary digit (sum modulo 2)
    }
    
    return sb.reverse().toString(); // Reverse the result since we constructed it in reverse order
}

        public static String addBinaryBitWise(String a, String b) {
            BigInteger x = new BigInteger(a, 2); // Convert binary string to BigInteger
            BigInteger y = new BigInteger(b, 2);

            while (!y.equals(BigInteger.ZERO)) {  // Run until carry is zero
                BigInteger sum = x.xor(y);  // XOR: Adds bits without carry
                BigInteger carry = x.and(y).shiftLeft(1); // AND + Left Shift: Compute carry
                x = sum;
                y = carry;
            }

            return x.toString(2);

        }
    public static void main(String[] args) {
        System.out.println(addBinary("111","11"));
    }
}
