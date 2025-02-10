
//Longest Common Prefix (leetcode)
class LongestCommonPrefix{
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1 ; i < strs.length ; i++){
            while(strs[i].indexOf(prefix) != 0){
                
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.length()== 0)
                    return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] arr = {"cir","car"};
        String str = longestCommonPrefix(arr);
        if(str.length() == 0)
            System.out.println("No common");
        else
            System.out.println("Common:" +str);
    }
}