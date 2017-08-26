package CodeChallenge.HackerRank;

import java.util.Scanner;

/*
* A string s contains many patterns of the form 1(0+)1 where (0+) represents any non-empty consecutive sequence of 0's.
* The patterns are allowed to overlap.
For example, consider string 1101001, we can see there are two consecutive sequences 1(0)1 and 1001 which are of the form 1(0+)1.

You have to answer q queries, each containing a string s.
For each query, find and print the total number of patterns of the form 1(0+)1 that occur in s.

Input Format

The first line contains a single integer , denoting the number of queries. After that,  lines follow. The  of them represents the  test case and contains a string  for this test case.

Constraints

 contains only digits and lowercase English letters
Output Format

Output exactly  lines, one for each testcase.

Sample Input 0

3
100001abc101
1001ab010abc01001
1001010001
Sample Output 0

2
2
3
Explanation 0

In the first case,  we have  as  and  as . Hence, we print  as the answer.
In the second case,  we have  as  and  as . Hence, we print  as the answer.
In the third case,  we have  as ,  as  and  as . Hence, we print  as the answer.
* */
public class PatternCount {
    static int patternCount(String s){
        if (s.length() == 1 || s.length() == 2)
            return 0;
        int head_index=0;
        int tail_index=0;
        int result=0;
        while (tail_index < s.length()){
            if (head_index < s.length()-2 && s.charAt(head_index) == '1' && s.charAt(head_index+1) == '0') {
                for (tail_index = head_index+1;tail_index < s.length();tail_index++){
                    if (s.charAt(tail_index) == '0'){
                        continue;
                    } else if (s.charAt(tail_index) == '1') {
                        result++;
                        break;
                    } else
                        break;
                }
                head_index = tail_index;
            }else {
                tail_index++;
                head_index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = patternCount(s);
            System.out.println(result);
        }
    }
}
