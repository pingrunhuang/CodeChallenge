package DataStructure.Sorting;

/**
 * O(N2)
 * selection means select the largest or smallest to be put on the front and do the same for the rest
 */

public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        int min = arr[0];
        int minIndex = 0;
        for (int i=0;i<arr.length - 1;i++){
            for (int j=i;j<arr.length;j++){
                if (arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
            min = arr[i+1];
            minIndex = i+1;
        }
        return arr;
    }
}
