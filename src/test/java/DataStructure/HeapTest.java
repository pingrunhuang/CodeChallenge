package DataStructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    static Heap<Integer> heap;

    @Before
    public void setup(){
        heap = new Heap<Integer>();
        heap.insert(21);
        heap.insert(1);
        heap.insert(5);
        heap.insert(6);
        heap.insert(9);
        heap.insert(11);
        heap.insert(8);
        heap.insert(15);
        heap.insert(17);
    }

    @Test
    public void testToString(){
        /*
        * 1
          6	    5
          15	9	11	8
          21	17
        * */

        System.out.println(heap.toString());
    }

    @Test
    public void testDelete(){
        heap.delete(1);
        System.out.println(heap.toString());
    }
}