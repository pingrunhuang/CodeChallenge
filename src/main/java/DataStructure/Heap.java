package DataStructure;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * min-heap: the parent node has a value less then the child node
 * max-heap: the parent node has a value lager then the child node
 * for a specify node at index:
 * 1. parent index: (index − 1)/2
 * 2. left child: 2 ∗ index + 1
 * 3. right child: 2 ∗ index + 2
 */

public class Heap <T extends Comparable>{
    // implementation of min-heap
    // requirement: non-null node
    List<T> heap;

    public Heap(){
        heap = new ArrayList<T>();
    }

    void insert(T value){
        // O[log(n)]
        // insert value part
        heap.add(value);

        // swap order part
        miniHeapify();
    }

    private int getTheMin(int index){
        int left_child = 2*index+1;
        int right_child = 2*index+2;
        if (right_child<heap.size()){
            // get the child node index with smaller value
            int to_compare_index = heap.get(right_child).compareTo(heap.get(left_child))>0 ?
                    left_child:right_child;
            if (heap.get(index).compareTo(to_compare_index)>0)
                return to_compare_index;
        }else if (left_child<heap.size()){
            if (heap.get(index).compareTo(left_child)>0)
                return left_child;
        }
        // no child node for the given node
        // or the given index is holding the min value
        // return the given node
        return index;
    }

    // this method is only usable when constructing the heap
    // because you can traverse very time you insert an element
    void miniHeapify(){
        int index = heap.size() - 1;
        while (index >= 0){
            // default to get the floor integer
            if (heap.get(index).compareTo(heap.get((index-1)/2))<0){
                T temp = heap.get(index);
                heap.set(index,heap.get((index-1)/2));
                heap.set((index-1)/2,temp);
            }
            index--;
        }
    }

    void miniHeapify(int index){
        // first situation: parent is smaller or given node is root
        // from down to top
        // I am exchanging the left child here, it could be right child
        if ((index-1)/2>=0 && heap.get((index-1)/2).compareTo(heap.get(index))<0){
            while (index >= 0){
                if (heap.get(index).compareTo(heap.get((index-1)/2))<0){
                    T temp = heap.get(index);
                    heap.set(index,heap.get((index-1)/2));
                    heap.set((index-1)/2,temp);
                }
                index--;
            }
        }else{
            // second situation: child is smaller
            // from top to down
            int largest_parent_index = heap.size()/2;
            while (index < largest_parent_index){
                if (heap.get(index).compareTo(heap.get(2*index+1))>0){
                    T temp = heap.get(index);
                    heap.set(index,heap.get(2*index+1));
                    heap.set(2*index+1,temp);
                }
                index++;
            }
        }
    }

    void delete(T target){
        int count = heap.size()-1;
        // 1.find the index to delete
        int index = heap.indexOf(target);
        if(index < 0){
            return;
        }
        // 2.put the last value of the heap to the location where item is deleted
        T lastElement = heap.get(count);
        heap.set(index, lastElement);
        heap.remove(count);
        // 3.reorder
        miniHeapify(index);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Queue<T> temp_queue = new LinkedList<T>();
        int current_index = 0;
        temp_queue.add(heap.get(current_index));
        int current_rightest_index = current_index;
        int next_row_rightest_index = current_index;
        while (!temp_queue.isEmpty()){
            stringBuffer.append(temp_queue.poll());

            int current_left_child = 2*current_index+1;
            int current_right_child = 2*current_index+2;
            // left child node not null
            if (current_left_child<heap.size()){
                temp_queue.add(heap.get(current_left_child));
                next_row_rightest_index = current_left_child;
            }
            if (current_right_child<heap.size()){
                temp_queue.add(heap.get(current_right_child));
                next_row_rightest_index = current_right_child;
            }

            if (current_index == current_rightest_index){
                stringBuffer.append("\n");
                current_rightest_index = next_row_rightest_index;
            }else{
                stringBuffer.append("\t");
            }
            current_index++;
        }
        return stringBuffer.toString();
    }
}
