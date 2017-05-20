package CodeChallenge.String;

/*
*    "1234"  "2341" "3412" "4123" are reverse string of "1234"
*    O(N)
* */

class IsReverseStr{
  /*
  * basic idea is going to traverse through the whole new added string
  */
  public static boolean isReverse(String str, String target_str){
    if(target_str.length() != str.length()){
      return false;
    }
    String tmp = str + str;
    int l = str.length();
    for (int i=0; i<str.length(); i++) {
      StringBuilder str_builder = new StringBuilder();
      for (int j=i; j<i+l; j++) {
        str_builder.append(tmp.charAt(j));
      }
      if(str_builder.toString().equals(target_str)){
        return true;
      }
    }
    return false;
  }
}
