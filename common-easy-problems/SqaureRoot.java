package org.anubhav;
/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
*/
public class SquareRoot {
        // Time:- O(log n)
        // space:- O(1)
        public static int mySqrt(int x) {
            if (x == 0) return 0; // Edge case: The square root of 0 is 0.

            int left = 1, right = x; // Define search space for binary search.

            while (left <= right) {
                int mid = left + (right - left) / 2; // Avoid potential overflow.
                long square = (long) mid * mid; // Use long to prevent overflow.

                if (square == x) {
                    return mid; // Found exact square root.
                } else if (square < x) {
                    left = mid + 1; // Move to the right half.
                } else {
                    right = mid - 1; // Move to the left half.
                }
            }

            return right; // The integer square root is stored in `right`.
        }

    public static void main(String[] args) {
    System.out.println(mySqrt(8));
    }
}
