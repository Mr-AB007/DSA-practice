/**
 * Problem Statement:
 * Given a character array, write a function to reverse the array in-place.
 * The function should modify the input array without using extra space.
 *
 * Example:
 * Input: ['h', 'e', 'l', 'l', 'o']
 * Output: ['o', 'l', 'l', 'e', 'h']
 */

public class ReverseStrin {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        for (int i = 0; i < right; i++) {
            char t = s[i];
            s[i] = s[right];
            s[right--] = t;
        }
    }

    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Original array: " + new String(input));
        
        reverseString(input);
        
        System.out.println("Reversed array: " + new String(input));
    }
}
