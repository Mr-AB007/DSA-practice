//Leetcode 49

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     

        Map<String,List<String>> result = new HashMap<>();

        for(String s:strs){
            int[] freq = new int[26];

            for(int i = 0; i< s.length();i++)
            {

                freq[s.charAt(i) - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : freq){
                sb.append(i);
                sb.append("#");
            }
            result.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);

        }
        return new ArrayList<>(result.values());
       
        
    }
}
