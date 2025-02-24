/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
*/


package org.anubhav;
import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
         // Iterate from the last digit to the first one (right to left)
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is less than 9, simply increment and return
            if (digits[i] < 9) {
                digits[i]++; // Increase the digit value by 1
                return digits; // Return the updated array
            }
            // If the digit is 9, set it to 0 (carry over to the next digit)
            digits[i] = 0;
        }

        // If all digits were 9 (e.g., 999 → 1000), create a new array
        digits = new int[digits.length + 1]; // New array with an extra space
        digits[0] = 1; // Set the first element to 1 (e.g., 999 → [1,0,0,0])
        return digits;
    }
    public static void main(String[] args) {
        int[] num = {1,2,9,9};
    System.out.println(Arrays.toString(plusOne(num)));
    }
}
