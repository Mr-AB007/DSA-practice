/*
 * Problem Statement:
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * 
 * Example:
 * Input: n = 10
 * Output: 4
 * Explanation: There are four prime numbers less than 10, which are 2, 3, 5, and 7.
 * 
 * Algorithm Used: Sieve of Eratosthenes
 * 
 * Time Complexity: O(n log log n) - The Sieve of Eratosthenes efficiently marks non-prime numbers,
 * reducing redundant computations.
 * 
 * Space Complexity: O(n) - A boolean array of size n is used to track prime numbers.
 */

class  SieveOfEratosthenes{
    public int countPrimes(int n) {
        // Boolean array to track prime numbers
        boolean[] arr = new boolean[n];
        int count = 0;

        // Edge case: If n is less than 2, there are no prime numbers
        if(n < 2)
            return count;

        // Implementing the Sieve of Eratosthenes algorithm
        for (int i = 2; i * i < n; i++) {  // Optimized loop condition (i < Math.sqrt(n))
            if (!arr[i]) { // If i is a prime number
                // Mark all multiples of i as non-prime (true)
                for (int j = i * i; j < n; j += i) {
                    arr[j] = true;
                }
            }
        }

        // Counting the number of prime numbers
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) { // If false, it means the number is prime
                count++;
            }
        }

        return count;
    }

    // Alternative method using an array filled with true values
    // public int countPrimes(int n) {
    //     if(n <= 2) return 0; // If n is 2 or less, there are no primes
    //     
    //     boolean[] isPrime = new boolean[n]; // Boolean array to track primes
    //     Arrays.fill(isPrime, true); // Initialize all as true
    //     isPrime[0] = false; // 0 is not prime
    //     isPrime[1] = false; // 1 is not prime
    //     
    //     for(int i = 2; i * i < n; i++) {
    //         if(isPrime[i]) { // If the number is prime
    //             for(int j = i * i; j < n; j += i) { // Mark multiples as non-prime
    //                 isPrime[j] = false;
    //             }
    //         }
    //     }
    //     
    //     int count = 0;
    //     for(int i = 0; i < n; i++) {
    //         if(isPrime[i]) count++;
    //     }
    //     return count;
    // }

    // Brute-force approach (inefficient for large n)
    // public boolean isPrime(int n) {
    //     if(n == 1 || n == 0)
    //         return false;
    //     if(n == 2 || n == 3)
    //         return true;
    //     if(n % 2 == 0 || n % 3 == 0)
    //         return false;
    //     
    //     for (int i = 5; i <= Math.sqrt(n); i += 6) // Check divisibility
    //         if (n % i == 0 || n % (i + 2) == 0)
    //             return false;
    //     
    //     return true;
    // }
}
