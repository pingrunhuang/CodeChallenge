package DataStructure;

/*
* The basic idea of KMP is going to compare every possible substring inside the pattern string
* so that we can calculate the next step the pattern string to slide to.
* */
public class KMP {
    // partial match table is gonna indicate the the matching length between all the suffix and prefix substring before index j
    // for example: "abcdabd"
    // prefix of index 5: [a], [a,b], [a,b,c], [a,b,c,d] exclude the "a" which is on the index of 4
    // suffix of index 5: [b], [a,b], [d,a,b], [c,d,a,b] exclude the "a" which is on the index of 0
    // actually, we can choose another strategy to include the index 5 to be counted into the substring.
    // the matching length is 2
    // therefore the value on the table of index 5 is 2
    // partialMatchingTable = [-1,0,0,0,1,2,0]
    public static int[] getPartialMatchTable(String patternStr){
        int[] result = new int[patternStr.length()];
        result[0] = -1;
        int prefix_index = -1, suffix_index = 0;
        while (suffix_index < patternStr.length() - 1){
            if (prefix_index == -1 || patternStr.charAt(suffix_index) == patternStr.charAt(prefix_index)){
                prefix_index++;
                suffix_index++;
                result[suffix_index] = prefix_index;
            }else{
                // let the prefix index pointer to point back to t
                prefix_index = result[prefix_index];
            }
        }
        return result;
    }
    public static int kmpMatch(String str, String patternStr){
        int str_pointer = 0;
        int pattern_pointer = 0;
        int[] next = getPartialMatchTable(patternStr);
        while (str_pointer < str.length() && pattern_pointer < patternStr.length()){
            if (pattern_pointer == -1 || str.charAt(str_pointer) == patternStr.charAt(pattern_pointer)){
                str_pointer++;
                pattern_pointer++;
            }else{
                pattern_pointer = next[pattern_pointer];
            }
        }
        if (pattern_pointer >= patternStr.length()){
            // found the first match
            return str_pointer - patternStr.length();
        }else{
            // not found
            return -1;
        }
    }
}
