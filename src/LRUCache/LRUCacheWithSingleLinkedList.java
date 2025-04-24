package CodeChallenge.LRUCache;

/*
* This implementation can reach O(1) time complexity when removing a node by using single linked list
* */

import org.junit.Test;

public class LRUCacheWithSingleLinkedList {

    int capacity;
    Node cacheList;
    // count the number of the cache node
    private int count;

    static class Node{
        Node next;
        int key;
        int value;
        Node(int key, int value){
           this.key = key;
           this.value = value;
        }
    }

    public LRUCacheWithSingleLinkedList(int capacity){
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key){
        if (cacheList == null)
            return -1;
        Node cur = cacheList;
        while (cur != null){
            // found
            if (cur.key == key){
                pushFront(cur);
                return cur.value;
            }
            cur = cur.next;
        }
        // not found
        return -1;
    }
    public void put(int key, int value){
        Node entry = new Node(key, value);
        if (cacheList == null) {
            cacheList = entry;
            count++;
            return;
        }
        Node cur = cacheList;
        while (cur != null){
            // check if the node to be insert is already in the cache list
            if (cur.key == key) {
                pushFront(cur);
                return;
            }
            cur = cur.next;
        }
        // node not exists and cache is full
        if (this.count == capacity){
            cur = cacheList;
            while (cur.next != null){
                cur = cur.next;
            }
            cur = null;
        }
        entry.next = cacheList;
        cacheList = entry;
        count++;
    }

    // this is the sugar to push the most recent used node to the front
    // only used when the node exists!
    private void pushFront(Node entry){
//        // cache is full
        if (this.count == capacity){
            Node cur = cacheList;
            while (cur.next != null){
                cur = cur.next;
            }
            cur = null;
        }
        // remove the next node
        remove(entry);
        // let the next node's value be the target node's value
        entry.next = cacheList;
        cacheList = entry;
    }

    // this is how we achieve O(1) complexity by exchanging the target node's value with the next node and delete the next node
    private void remove(Node entry){
        if (cacheList == null){
            return;
        }
        // the node is at tail
        if (entry.next == null){
            entry = null;
        } else {
            entry.value = entry.next.value;
            entry.next = entry.next.next;
        }
    }


    public static void main(String[] args){
        LRUCacheWithSingleLinkedList cache = new LRUCacheWithSingleLinkedList( 2 /* capacity */ );
        cache.put(1, 1);
        System.out.println("Count: " + cache.count);
        cache.put(2, 2);
        System.out.println("Count: " + cache.count);
        System.out.println(cache.get(1));       // returns 1
        System.out.println("Count: " + cache.count);
        cache.put(3, 3);    // evicts key 2
        System.out.println("Count: " + cache.count);
        cache.get(2);       // returns -1 (not found)
        System.out.println("Count: " + cache.count);
        cache.put(4, 4);    // evicts key 1
        System.out.println("Count: " + cache.count);
        cache.get(1);       // returns -1 (not found)
        System.out.println("Count: " + cache.count);
        cache.get(3);       // returns 3
        System.out.println("Count: " + cache.count);
        cache.get(4);       // returns 4
        System.out.println("Count: " + cache.count);
    }
}
