package CodeChallenge.HackerRank;

/*
*
Input Format

The first line contains an integer  denoting the size of two arrays.
Each of the next two lines contains  space separated integers denoting array  and  respectively.

Constraints:
2 <= n <= 10^5
1 <= array_elements <= 10^5

Output Format

Print the minimum sum which can be obtained under the conditions mentioned in the problem statement.

Sample Input 0

5
5 4 3 2 1
1 2 3 4 5
Sample Output 0

2
* */

import java.util.*;

public class Twin_Arrays {
    static class Entry implements Comparable<Entry>{
        int value;
        int index;
        Entry(int v, int i){
            this.value = v;
            this.index = i;
        }

        public int compareTo(Entry o) {
            return value>o.value ? 1 : (value < o.value ? -1 : 0) ;
        }
    }

    static int twinArrays(int[] ar1, int[] ar2){

        List<Entry> list1 = new ArrayList<Entry>();
        List<Entry> list2 = new ArrayList<Entry>();

        for (int i=0;i<ar1.length;i++){
            list1.add(new Entry(ar1[i],i));
            list2.add(new Entry(ar2[i],i));
        }
        Collections.sort(list1);
        Collections.sort(list2);

        if (list1.get(0).index != list2.get(0).index){
            return list1.get(0).value + list2.get(0).value;
        }else if (list1.get(0).value < list2.get(0).value){
            return list1.get(0).value + list2.get(1).value;
        }else if (list1.get(0).value == list2.get(0).value){
            return list1.get(1).value < list2.get(1).value ? list1.get(1).value + list2.get(0).value : list1.get(0).value + list2.get(1).value;
        }else {
            return list1.get(1).value + list2.get(0).value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar1 = new int[n];
        for(int ar1_i = 0; ar1_i < n; ar1_i++){
            ar1[ar1_i] = in.nextInt();
        }
        int[] ar2 = new int[n];
        for(int ar2_i = 0; ar2_i < n; ar2_i++){
            ar2[ar2_i] = in.nextInt();
        }
        int result = twinArrays(ar1, ar2);
        System.out.println(result);
    }
}
