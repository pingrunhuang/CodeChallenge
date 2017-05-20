package DataStructure;


import DataStructure.Sorting.InsertSort;
import DataStructure.Sorting.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

public class SortingTest {

    @Test
    public void testInsertSort(){
        int[] a = {6,3,5,7,0,4,1,2};
        int[] b = {0,1,2,3,4,5,6,7};

        Assert.assertArrayEquals(b, InsertSort.sort(a));
    }

    @Test
    public void testSelectionSort(){
        int[] a = {6,3,5,7,0,4,1,2};
        int[] b = {0,1,2,3,4,5,6,7};

        Assert.assertArrayEquals(b, SelectionSort.selectionSort(a));
    }

    @Test
    public void testInsertionSort(){

    }

    @Test
    public void testHeapSort(){

    }
}
