package CodeChallenge.LRUCache;

// using double linked list to implement the LRU is straight forward yet with O(1) time complexity when removing the node
// trade space resources for time resources
public class LRUCacheWithDoubleLinkedList {
    int capacity;
    Node HEAD;
    Node TAIL;

    // count the number of the cache node
    private int count;

    static class Node{
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCacheWithDoubleLinkedList(int capacity){
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key){
        if (HEAD == null)
            return -1;
        Node cur = HEAD;
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
        if (HEAD == null) {
            HEAD = entry;
            count++;
            return;
        }
        pushFront(entry);
    }

    // this is the sugar to push the most recent used node to the front
    private void pushFront(Node entry){

        // if entry not exists and cache not full
        if (!isExists(entry) && this.count < capacity){
            entry.next = HEAD;
            HEAD = entry;
            entry.next.prev = entry;
            this.count++;
            return;
        }
        // if entry not exists and cache full
        if (!isExists(entry) && this.count == capacity) {
            Node cur = HEAD;
            while (cur.next != null) {
                cur = cur.next;
            }
            // remove the last node
            remove(cur);
            entry.next = HEAD;
            HEAD = entry;
            entry.next.prev = entry;
            return;
        }

        // if entry exists, you do not need to verify if the cache is full or not
        if (isExists(entry)){
            // in this case, we need to get the
            remove(entry);
            entry.next = HEAD;
            HEAD = entry;
            entry.next.prev = entry;
            return;
        }
    }

    // this is how we achieve O(1) complexity by exchanging the target node's value with the next node and delete the next node
    private void remove(Node entry){
        if (HEAD == null){
            return;
        }
        // only 1 node
        if (HEAD.prev == null && HEAD.next == null)
            return;

        Node prev = entry.prev;
        Node next = entry.next;
        // the node is at tail
        if (next == null){
            prev.next = null;
        }else if (prev == null){
            //head
            next.prev = null;
        }else {
            prev.next = next;
            next.prev = prev;
        }
    }

    private boolean isExists(Node entry){
        if (HEAD == null)
            return false;
        Node cur = HEAD;
        while (cur != null){
            if (cur.key == entry.key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args){
        LRUCacheWithDoubleLinkedList cache = new LRUCacheWithDoubleLinkedList( 2 /* capacity */ );
        cache.put(1, 1);
        System.out.println("Count: " + cache.count);
        cache.put(2, 2);
        System.out.println("Count: " + cache.count);
        System.out.println(cache.get(1));       // returns 1
        System.out.println("Count: " + cache.count);
        cache.put(3, 3);    // evicts key 2
        System.out.println("Count: " + cache.count);
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println("Count: " + cache.count);
        cache.put(4, 4);    // evicts key 1
        System.out.println("Count: " + cache.count);
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println("Count: " + cache.count);
        System.out.println(cache.get(3));       // returns 3
        System.out.println("Count: " + cache.count);
        System.out.println(cache.get(4));       // returns 4
        System.out.println("Count: " + cache.count);
//        LRUCacheWithDoubleLinkedList cache = new LRUCacheWithDoubleLinkedList(1);
//        cache.put(2,1);
//        System.out.println(cache.get(2));
    }
}
