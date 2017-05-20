package DataStructure.Sorting;

import org.junit.Test;

/*
* heap definition：
* n key array : k[1], k[2], k[3], k[4] ...k[n] is called heap，only if
* k[i] <= k[2 * i] && k[i] <= k[2 * i] + 1 (minimum heap)
* or
* k[i] >= k[2 * i] && k[i] >= k[2 * i] + 1 (maximum heap)
*
* setps:
* 1. for a given index i, if k[i] < k[2*i] or k[i] < k[2*i+1] then swap it. repeat it to get the max heap
* 2. the root must be the largest number now, replace it with the last item and reduce the size of heap by 1
* 3. repeat step 1 and 2
*
* the basic idea is to sort while heapifying
* */
// TODO
public class HeapSort {

    // initialize max heap
    // this is just a partial initialization considering 3 element
    public static void heapify(int[] input, int low, int high){
        int largest = low;
        int left = 2 * low + 1;
        int right = 2 * low + 2;
        if (right<=high && input[largest] < input[right])
            largest = right;
        if (left<=high && input[largest] < input[left])
            largest = left;

        if (largest != low){
            // swap without adding third variable
            input[low] = input[largest] + input[low];
            input[largest] = input[low] - input[largest];
            input[low] = input[low] - input[largest];
            heapify(input,largest, high);
        }
    }

    public static void startSorting(int[] a){
        // ascending
        int index = a.length - 1;
        heapify(a, 0, a.length - 1);
        while (index > 0){
            if (a[0] > a[index]){
                // swap and heapify
                a[0] = a[0] + a[index];
                a[index] = a[0] - a[index];
                a[0] = a[0] - a[index];
                index = index - 1;
                heapify(a, 0, index);
            }
        }
    }

    @Test
    public void testHeapSort(){
        int[] input = {4, 10, 3, 5, 1};
        startSorting(input);
        for (int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
        input = new int[]{6, 8, 7, 9, 0, 1, 3, 2, 4, 5};
        startSorting(input);
        for (int i : input){
            System.out.print(i + " ");
        }
    }
}
