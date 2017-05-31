package DataStructure;

/*
* when it comes to big data, we can leverage the bitmap to query data
* this is a simple implementation of bitmap, see sun.jvm.hotspot.utilities.BitMap for full
* */

import org.junit.Assert;
import org.junit.Test;

/*
* Question:
*   Given a value, how do you decide the unique index for it inside a bitmap?
* Solution:
*   1. value >> length_of_bitmap, I call it rough indexing because we are going to determine which bucket to put the given value by using the information of multiple
*   2. value & length_of_bitmap, I call it exact indexing since we are going to label this exact index as 1 or 0 according to the given value.
*       From value % length_of_bitmap to 2 * value % length_of_bitmap - 1
* */

public class BitMap {
    // we assume the operating system is 32 bit
    private static final int SHIFT = 5; // 2^5 = 32, 32 bit = 8 bytes = 1 int
    private static final int MASK = 0X1F; // hex equivalent to 32
//    private static int[] bitMap; // used for indexing the bit translated from certain value
    private static int[] origin_array;
    private static int BYTESIZE = 8;


    /*
    * Initialize the array with all 0 in it
    * @param    the value to be put in the bitmap
    * @param    array of int to be initialize as 0, each element is actually a bucket,
    *           inside a bucket will have a int value to be index on each bit position to be 1 or 0
    * */
    static void set(int n, int[] bitMap){
        // bitmap[i / 32] |= 1 << i % 32;
        int index_loc = n >> SHIFT; // n / SHIFT, to find the given value's bucket index
        int bit_loc = n & MASK; // n % MASK, to find which bit location this value is going to be placed
        bitMap[index_loc] |= 1 << bit_loc; // if it's already occupied, then the value should stay the same, otherwise set to 1.
    }

    static int[] initial(int[] origin_array){
        int max_value = 0;
        // find the largest value
        for (int v : origin_array){
            if (v > max_value)
                max_value = v;
        }
        // max_value / 32 + 1, to get the actual index_loc
        int[] bitMap = new int[(max_value >> SHIFT) + 1];
        return bitMap;
    }

    static int[] bitmap_sort(int[] data, int[] bitMap){
        int i = 0;
        int[] result = new int[data.length];
        // first insert the value into the bitmap
        for (int v : data){
            set(v, bitMap);
        }

        // second, for each bit, if the value is 1, then print it
        for(int bucket_index = 0; bucket_index < bitMap.length; ++bucket_index) {
            int bit = 1;
            while(bitMap[bucket_index] != 0) {
                if ((bitMap[bucket_index] & 1) == 1) {
//                    System.out.println((32 * bucket_index) + bit - 1);
                    result[i++] = (32 * bucket_index) + bit - 1;
                }
                bitMap[bucket_index] >>>= 1;
                ++bit;
            }
        }
        return result;
    }

    @Test
    public void testInitialize(){
        origin_array = new int[]{1,2,3,4,5,76,8,11,32};

        int[] initialed_bitmap = initial(origin_array);
        for (int i=0;i<initialed_bitmap.length;i++){
            System.out.print(initialed_bitmap[i] + " ");
        }

        int[] expected = new int[]{1,2,3,4,5,8,11,32,76};
        Assert.assertArrayEquals(expected, bitmap_sort(origin_array, initialed_bitmap));
        System.out.println(Integer.MAX_VALUE);
        Assert.assertEquals((1 << 31) - 1, Integer.MAX_VALUE);
    }

}
