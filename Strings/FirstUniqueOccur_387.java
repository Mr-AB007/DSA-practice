// leetcode 387
class Solution {
    public int firstUniqCharUsingFreq(String s) {
        int n = s.length();
     char[] freq = new char[256];

     for(int i = 0; i < n; i++){
        freq[s.charAt(i)]++;
     }   

     for(int i = 0; i < n; i++){
        if(freq[s.charAt(i)] == 1){
            return i;
        }
     }

     return -1;
    }

 public int firstUniqChar(String s) {
       int n = s.length();
       Map<Character,Integer> map = new LinkedHashMap<>();

       for (char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0) + 1);
       
       for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return s.indexOf(entry.getKey());
            }
       }
       return -1;
    }
}
