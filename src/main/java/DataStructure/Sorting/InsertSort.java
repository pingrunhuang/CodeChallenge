package DataStructure.Sorting;

/*
* 插入排序的思想更接近于扑克牌的排序
* 先第一张和第二张比较，第二张小于第一张，则交换
* 然后第三张和第二张比较，若小于第二张就再和第一张比较并进行第一步操作
* 以此类推
* O(N2)
* */
public class InsertSort{
    public static int[] sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int temp = arr[i];
            for (int j = i-1;j>=0;j--){
                if (temp < arr[j]){
                    arr[j+1] = arr[j];
                    // insert happen here
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}