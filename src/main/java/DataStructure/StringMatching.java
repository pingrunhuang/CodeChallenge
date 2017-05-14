package DataStructure;

/**
* 一个字节8位，表示一个字符（该字符的ASCII码），32位可以存储8个字节
* 串结构分为顺序串和链串
* 串的模式匹配：Brute-Force算法和KMP算法
*/

public class StringMatching{
  private static final String str = "abcabdabcabdabcabdabdabc";

  public static int BFMatching(String t){
    int i = 0;//used for recording the index of the source string
    int j = 0;//used for recording the index of the target string

    while(i<str.length() && j<t.length()){
      // a1...a(i-j),a(i-j+1)...a(i-1),a(i)...a(n)
      //        |     |          |    \
      //      t(0),t(1).....t(j-1),t(j)...
      //O(t.length)
      if(str.charAt(i) == t.charAt(j)){
        i++;
        j++;
      }else{
        i = i-j+1;
        j = 0;
      }
    }
    if(j >= t.length()){
      // return the index of the first matched char
      return (i - t.length());
    }else{
      return -1;
    }
  }


  // not quite understand yet
  public static int KMPMatching(String t){
    // O(n+m)
    int PATTERN_LENGTH = t.length();
    Integer[] next = new Integer[PATTERN_LENGTH];
    int i = 0;
    int j = 0;
    getNext(t, next);
    while(i<str.length() && j<PATTERN_LENGTH){
      if(j == -1 || str.charAt(i) == t.charAt(j)){
        i++;
        j++;
      }else{
        j = next[j];
      }
    }
    if(j>=PATTERN_LENGTH){
      return (i-PATTERN_LENGTH);
    }else{
      return -1;
    }
  }

  public static void getNext(String t, Integer[] next){
    // we got a next table indicating how many index should the t string slide over for the next iteration which is j-next[j]
    int j = 0;
    int k = -1; //
    next[0] = -1; //
    while(j < t.length() - 1){
        if(k == -1 || t.charAt(j) == t.charAt(k)){
          j++;
          k++;
          next[j] = k;
        }else{
          k = next[k];
        }
    }
  }

  public static void main(String[] args){
    String t = "abcabdabc";
    System.out.println(BFMatching(t));
    System.out.println(KMPMatching(t));
  }

}
