/*
Problem Statement:
------------------
Given an array of strings, group the anagrams together.
Two strings are anagrams if they contain the same characters in the same frequency,
but possibly in a different order.

Example:
Input:  ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

Approach:
---------
1. For each string, create a "canonical key" that uniquely represents its character counts.
   - Use an integer array of size 26 (for lowercase 'a' to 'z') to count characters.
   - Convert this count array into a string key (e.g., "1#0#0#...").
2. Use a HashMap<String, List<String>> to group strings by their canonical key.
3. Return the grouped lists.

Complexity Analysis:
--------------------
Let:
- N = number of strings
- L = maximum length of a string

Time Complexity:
- Counting characters for each string: O(L)
- Building the key string: O(26) = O(1) (constant for lowercase English letters)
- Inserting into HashMap: O(1) average
Overall: O(N * L)

Space Complexity:
- HashMap stores all strings: O(N * L) total characters
- Temporary count array: O(26) = O(1)
- Key strings: O(N * 26) = O(N)
Overall: O(N * L)
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map from canonical key to list of anagrams
        HashMap<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            // Generate the canonical key for the string
            String angStr = helper(s);

            // If key doesn't exist, create new list; then add the string
            result.computeIfAbsent(angStr, k -> new ArrayList<>()).add(s);
        }

        // Return all grouped anagrams
        return new ArrayList<>(result.values());
    }

    // Helper method to generate a canonical key based on character counts
    public String helper(String str) {
        int[] chs = new int[26]; // count array for 'a' to 'z'

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            chs[c - 'a']++;
        }

        // Build a string key from counts
        StringBuilder sb = new StringBuilder();
        for (int i : chs) {
            sb.append(i).append('#'); // '#' as delimiter to avoid ambiguity
        }
        return sb.toString();
    }
}
