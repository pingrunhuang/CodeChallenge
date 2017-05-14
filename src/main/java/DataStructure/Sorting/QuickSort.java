package DataStructure.Sorting;

public class QuickSort{
  // O(n) = NlogN
  // partition -> recursive sort on 2 part
  public static void swap(Integer[] arr, int index1, int index2){
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  // partition will return the index of the rightmarker
  public static int partition(Integer[] arr, int start, int end){
    int leftMarker = start + 1;
    int rightMarker = end;
    int pivot = arr[start];
    // loop till 2 marker meet
    while(leftMarker < rightMarker){
      while(leftMarker <= rightMarker && arr[leftMarker] < pivot){
        leftMarker++;
      }
      while(leftMarker <= rightMarker && arr[rightMarker] > pivot){
        rightMarker--;
      }
      if(leftMarker > rightMarker){
        break;
      }else{
        swap(arr, leftMarker, rightMarker);
      }
    }
    swap(arr, start, rightMarker);
    return rightMarker;
  }

  public static void recursiveSort(Integer[] arr, int start, int end){
    if(start < end){
      int splitPoint = partition(arr, start, end);
      recursiveSort(arr, start, splitPoint-1);
      recursiveSort(arr, splitPoint + 1, end);
    }
  }

  public static void quickSort(Integer[] arr){
    recursiveSort(arr, 0, arr.length - 1);
  }

  public static void main(String[] args){
    Integer[] arr = {54,26,93,17,77,31,44,55,20};
    quickSort(arr);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();

  }
}
