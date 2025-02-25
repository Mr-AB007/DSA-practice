import java.util.*;
// Given an array of strings strs, group the anagrams together. You can return the answer in any order. Read Array.md for details 


class  GroupAnagrams{
    /*
    Sorting-Based Solution
    ***************************************
    Sorting each string: O(K log K), where K is the max length of a string.
    Iterating over N strings: O(N).
    Total Complexity: O(N * K log K), where N is the number of words.
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to character array, sort it, and convert it back to string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray); // This acts as the key for anagrams
          /*
            if(! map.containsKey(sortedStr)){    //if key is not present create
                map.put(sortedStr, new ArrayList<>()); //add the key and create a arraylist for values
            }
            map.get(sortedStr).add(str); //add the anagrams as values for their respective sorted keys
          */

            // Add to HashMap: If key exists, append to the list; otherwise, create a new list
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str); //same work as above using if
        }

        // Return all grouped anagram lists
        return new ArrayList<>(map.values());
    }


    /*
    Character Frequency-Based Solution (Optimized)
    **********************************************
    Building frequency key: O(K). k is size of each string
    Iterating over N strings: O(N).
    Total Complexity: O(N * K), which is better when K is large
    */
    public List<List<String>> groupAnagramsCount(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int freq : count) {
                keyBuilder.append(freq).append("#");
            }
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);

        System.out.println(result);
        // Output: [[eat, tea, ate], [tan, nat], [bat]]
    }
}
