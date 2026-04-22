/*
 Problem: Remove Anagrams (LeetCode) 2273

Given an array of strings `words`, remove all words that are anagrams of the 
previous word (only consecutive comparison).

Return the resulting list after removing such words.

 Key Constraint:
Only compare with the LAST kept word (not all previous words).

------------------------------------------------------------

 Approach 1 (Optimized - Frequency Signature) 

Idea:
- Two strings are anagrams if their character frequencies match.
- Instead of sorting (O(k log k)), we build a frequency-based signature (O(k)).
- Compare current word’s signature with previous word’s signature.

Steps:
1. Initialize result list.
2. Maintain a variable `prev` to store last accepted word's signature.
3. For each word:
   - Generate signature using frequency count.
   - If signature != prev → add word to result.
   - Update prev.

Time Complexity: O(n * k)
Space Complexity: O(k)

------------------------------------------------------------

 Approach 2 (Sorting - Brute/Classic)

Idea:
- Sort characters of both strings and compare.
- If sorted strings are equal → they are anagrams.

Time Complexity: O(n * k log k)
(Slower due to sorting)

------------------------------------------------------------
*/

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
      
      // result.add(words[0]);
        // for(int i = 1; i < words.length;i++){
        //     if(!isAnagrams(result.get(result.size() - 1),words[i]))
        //         result.add(words[i]);
       // }
      

        // Stores signature of last valid word
        String prev = "";

        for (String word : words) {
            // Generate frequency-based signature
            String current = getSignature(word);

            // Only add if it's NOT an anagram of previous
            if (!prev.equals(current)) {
                result.add(word);
                prev = current; // update previous signature
            }
        }

        return result;
    }

    /*
    🔹 Generates a unique signature based on character frequency

    Example:
    "abb" → a=1, b=2 → "1#2#0#0#..."

    Why '#'?
    - Prevents ambiguity
    - Example:
        Without '#': "110" → could be [1,10] or [11,0]
        With '#': "1#10#" vs "11#0#" → clear distinction
    */
    public String getSignature(String s) {
        int[] count = new int[26];

        // Count frequency of each character
        for (int ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Build signature string
        StringBuilder sb = new StringBuilder();
        for (int freq : count) {
            sb.append(freq).append("#");
        }

        return sb.toString();
    }

    /*
    🔹 Sorting-based Anagram Check (Alternative Approach)

    Logic:
    - Convert strings to char array
    - Sort both arrays
    - Compare arrays

    Less efficient than frequency approach

    public boolean isAnagram(String s, String s1) {
        if (s.length() != s1.length())
            return false;

        char[] c1 = s.toCharArray();
        char[] c2 = s1.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }
    */
}
