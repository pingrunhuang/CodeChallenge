package DataStructure;

/**
* 一个字节8位，表示一个字符（该字符的ASCII码），32位可以存储8个字节
* 串结构分为顺序串和链串
* 串的模式匹配：Brute-Force算法和KMP算法
*/

public class StringMatching{

  public static int BFMatching(String str, String pattern_str){
    int i = 0;//used for recording the index of the source string
    int j = 0;//used for recording the index of the target string

    while(i<str.length() && j<pattern_str.length()){
      // a1...a(i-j),a(i-j+1)...a(i-1),a(i)...a(n)
      //        |     |          |    \
      //      t(0),t(1).....t(j-1),t(j)...
      //O(t.length)
      if(str.charAt(i) == pattern_str.charAt(j)){
        i++;
        j++;
      }else{
        i = i-j+1;
        j = 0;
      }
    }
    if(j >= pattern_str.length()){
      // return the index of the first matched char
      return (i - pattern_str.length());
    }else{
      return -1;
    }
  }

}
