package DataStructure.Sorting;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MergeSort{
  // O(n) = nlog(n)
  public static Integer[] merge(Integer[] a, Integer[] b){
    List<Integer> aList = new ArrayList<Integer>(Arrays.asList(a));
    List<Integer> bList = new ArrayList<Integer>(Arrays.asList(b));
    List<Integer> temp = new ArrayList<Integer>();
    while( !aList.isEmpty() && !bList.isEmpty() ){
      if(aList.get(0) < bList.get(0)){
        temp.add(aList.get(0));
        aList.remove(0);
      }else{
        temp.add(bList.get(0));
        bList.remove(0);
      }
    }
    while(!aList.isEmpty()){
      temp.add(aList.get(0));
      aList.remove(0);
    }
    while(!bList.isEmpty()){
      temp.add(bList.get(0));
      bList.remove(0);
    }
    Integer[] result = new Integer[temp.size()];
    for (int i = 0; i < temp.size(); i ++){
      result[i] = temp.get(i);
    }
    return result;
  }

  public static Integer[] mergeSort(Integer[] list){
    if (list.length <= 1){
      return list;
    }
    int middle = list.length / 2;
    Integer[] left = Arrays.copyOfRange(list,0,middle);
    Integer[] right = Arrays.copyOfRange(list, middle, list.length);
    left = mergeSort(left);
    right = mergeSort(right);
    return merge(left,right);
  }

  public static void main(String[] args){
    Integer[] test = {10,19,14,35,31,42,27};
    // 10 14 19 27 31 35 42
    Integer[] result = mergeSort(test);
    for(int i = 0;i < test.length; i++){
      System.out.print(result[i] + " ");
    }
  }
}
