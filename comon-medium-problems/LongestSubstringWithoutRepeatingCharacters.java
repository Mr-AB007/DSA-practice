class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int len = s.length();
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < len; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left++));
            }
             set.add(s.charAt(i));
             max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
