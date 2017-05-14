package DataStructure.Sorting;

public class BubbleSort{

  public static void swap(Integer a, Integer b, Integer[] list){
    Integer temp = list[a];
    list[a] = list[b];
    list[b] = temp;
  }

  public static Integer[] bubbleSort(Integer[] list){
    // O(n2)
    // descending
    for(int i=0;i<list.length;i++){
      for(int j=list.length-1;j>i;j--){
        if(list[i]<list[j]){
          swap(i,j,list);
        }
      }
    }
    return list;
  }

  public static void main(String[] args){
    Integer[] test = {10,19,14,35,31,42,27};
    Integer[] result = bubbleSort(test);
    for(int i = 0;i < test.length; i++){
      System.out.print(result[i] + " ");
    }
  }
}
