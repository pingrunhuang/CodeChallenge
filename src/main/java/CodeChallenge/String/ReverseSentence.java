package CodeChallenge.String;

/*
* Given a sentence, reverse the sentence by word
* example:
* "I love dog" -> "dog love I"
* Solution:
* 1. reverse the whole sentence
* 2. for each word, reverse them back
* */


public class ReverseSentence {
    public static String reverse(String sentence){
        StringBuilder result = new StringBuilder();

        for (int i = sentence.length()-1; i>=0; i--){
            result.append(sentence.charAt(i));
        }

        return result.toString();
    }

    public static String reverseEveryWord(String sentence){
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split("\\W");
        for (int i=0;i<words.length;i++){
            String reversedWord = reverse(words[i]);
            if (i == words.length-1){
                result.append(reversedWord);
            }else{
                result.append(reversedWord + " ");
            }
        }
        return result.toString();
    }

    public static String getResult(String str){
        String reversedStr = reverse(str);
        return reverseEveryWord(reversedStr);
    }


}
