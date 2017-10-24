package DataStructure;

/*
* when it comes to big data, we can leverage the bitmap to query data
* this is a simple implementation of bitmap, see sun.jvm.hotspot.utilities.BitMap for full
* 先看看这样的一个场景：给一台普通PC，2G内存，要求处理一个包含40亿个不重复并且没有排过序的无符号的int整数，给出一个整数，
* 问如何快速地判断这个整数是否在文件40亿个数据当中？
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
    private static final int MASK = 0X1F; // hex equivalent to 31
    private static int BYTESIZE = 8;
    // 2 integer to represent the x axis and y axis respectively
    private static int[] bit_map= new int[2];


    /*
    * Initialize the array with all 0 in it
    * First find the block then goes to the exact index inside the block
    * @param    the value to be put in the bitmap
    * @param    array of int to be initialize as 0, each element is actually a bucket,
    *           inside a bucket will have a int value to be index on each bit position to be 1 or 0
    * */
    public static void set(int n){
        /*
        * a >> b : a / (2^b)
        * n & 0X1F == n & (0001 1111) : only keep the last 5 bit
        * */
        // bitmap[i / 32] |= 1 << i % 32;
        int y_loc = n >> SHIFT; // n / SHIFT, to find the given value's bucket index
        int x_loc = n & MASK; // n % MASK, to find which bit location this value is going to be placed
        // if it's already occupied, then the value should stay the same, otherwise set to 1.
        bit_map[0] |= 1 << y_loc;
        bit_map[1] |= 1 << x_loc;
    }

    public static boolean validate(int n){
        int y_loc = n >> SHIFT;
        int x_loc = n & MASK;

        if (Integer.toBinaryString(bit_map[0]).charAt(y_loc) == 1 ){
            return true;
        }
        return false;
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
//
//    static int[] bitmap_sort(int[] data, int[] bitMap){
//        int i = 0;
//        int[] result = new int[data.length];
//        // first insert the value into the bitmap
//        for (int v : data){
//            set(v, bitMap);
//        }
//
//        // second, for each bit, if the value is 1, then print it
//        for(int bucket_index = 0; bucket_index < bitMap.length; ++bucket_index) {
//            int bit = 1;
//            while(bitMap[bucket_index] != 0) {
//                if ((bitMap[bucket_index] & 1) == 1) {
////                    System.out.println((32 * bucket_index) + bit - 1);
//                    result[i++] = (32 * bucket_index) + bit - 1;
//                }
//                bitMap[bucket_index] >>>= 1;
//                ++bit;
//            }
//        }
//        return result;
//    }

    @Test
    public void testInitialize(){
        int[] data = {3,33231,2131313331,321321, 432432141};

        for (int d : data){
            System.out.println("Storing " + d + " into bitmap");
            set(d);
        }
        System.out.println(Integer.toBinaryString(bit_map[0]));
        System.out.println(Integer.toBinaryString(bit_map[1]));

        System.out.println("Check");

        for (int d : data){
            if (validate(d)){
                System.out.println(d + " is inside the bitmap");
                continue;
            }
            System.out.println(d + " is not inside the bitmap");
        }

    }
}
