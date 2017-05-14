package DataStructure;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * min-heap: the parent node has a value less then the child node
 * max-heap: the parent node has a value lager then the child node
 * for a specify node at index:
 * 1. parent index: (index − 1)/2
 * 2. left child: 2 ∗ index + 1
 * 3. right child: 2 ∗ index + 2
 */

//TODO
public class Heap <T extends Comparable>{
  // implementation of min-heap
  // requirement: non-null node
  ArrayList<T> heap;

  Heap(){
    heap = new ArrayList<T>();
  }

  void insert(T value){
    // O[log(n)]
    // insert value part
    heap.add(value);

    // swap order part
    minHeapify();
  }

  void minHeapify(){
    int index = heap.size() - 1;
    while ( index >= 0 && heap.get(index).compareTo(heap.get((index-1)/2)) >0){
      swap(heap.get(index), heap.get((index-1)/2));
      index = (index-1)/2;
    }
  }

  void swap(T a, T b){
    T temp = a;
    a = b;
    b = temp;
  }


  Boolean delete(T target){
    int count = heap.size() - 1;
    // 1.find the index to delete
    int index = heap.indexOf(target);
    if(index < 0){
      return false;
    }
    // 2.put the last value of the heap to the location where item is deleted
    T lastElement = heap.get(count);
    heap.set(index, lastElement);
    heap.remove(count);
    count = count - 1;
    // 3.reorder
    if ( (index - 1)/2 >= 0){
      if (heap.get((index - 1)/2).compareTo(heap.get(index)) > 0){
        swap(heap.get(index), heap.get((index-1)/2));
      }
    }
    int left = index + 1;
    int right = index + 2;
    while(left < count && (heap.get(index).compareTo(heap.get(left)) > 0 || heap.get(index).compareTo(heap.get(right)) >0)){
      if(heap.get(left).compareTo(heap.get(right)) > 0){
//        swap()
      }
    }
    return false;
  }

  public static void main(String[] args) {

  }
}
