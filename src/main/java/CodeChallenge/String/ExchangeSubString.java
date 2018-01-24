package CodeChallenge.String;

/*
* Given a string, and an index i.
* exchange the sub string [0,i] and [i+1, end]
* example:
* "ABCDE" -> "DEABC" with i = 2
* time complexity: O(N)
* extra space complexity: O(1) (means no string is created)
* */

public class ExchangeSubString {
    public static String reverse(String sentence){
        StringBuilder result = new StringBuilder();

        for (int i = sentence.length()-1; i>=0; i--){
            result.append(sentence.charAt(i));
        }
        return result.toString();
    }

    public static String exchange(String str, int index){
        // notice the substring don't include the left index
        return reverse(reverse(str).substring(0,str.length() - index - 1)) +
                reverse(reverse(str).substring(str.length() - index - 1, str.length()));
    }
}
