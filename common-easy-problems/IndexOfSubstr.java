/*
Find the Index of the First Occurrence in a String
*/
public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);  //using indexOf()
        int j = needle.length();
        for(int i = 0; i <= haystack.length() - j; i++){
            if(haystack.substring(i,i+j).equals(needle))  //using substring()
                return i;
        }
        return -1;
    }
