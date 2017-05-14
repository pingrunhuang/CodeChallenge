package CodeChallenge.LRUCache;

import java.util.HashMap;

public class LRUCache {
    // It's optional. Otherwise you will just have a doublelinkedlist
    static int capacity;
    static Node HEAD;

    static class Node {
        Node preNode;
        Node nextNode;
        int count;
        int key;
        int value;
        Node(Node pre, Node next, int count, int key, int value){
            this.preNode = pre;
            this.nextNode = next;
            this.count = count;
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache(int c) {
        capacity = c;
    }

    public static int get(int key) {
        while(HEAD.nextNode != null){
            if(HEAD.key == key){
                HEAD.count++;
                return HEAD.value;
            }
            HEAD = HEAD.nextNode;
        }
        return -1;
    }

    public static void set(int key, int value) {

        int count = 0;// used to count if the list is full

        if (HEAD == null){
            HEAD = new Node(null, null, 1, key, value);
        }
        Node currentNode = HEAD;
        while(currentNode != null){

            if(currentNode.key == key){// the key already exists
                currentNode.count++;
                currentNode.value = value;
            }else if(count >= capacity){
                // reached the capacity and the target key is not in the cache list
                // you also come to the end of the link list
                // have to find the least used node to be replaced by the new node;
                remove(findLeastUsedNoed());
                currentNode.nextNode = new Node(currentNode,null, 1, key, value);
                break;
            }else if(currentNode.nextNode == null){// have not reached the capacity and no more element after current head
                Node newNode = new Node(currentNode,null, 1, key, value);
                currentNode.nextNode = newNode;
                break;
            }
            count++;
            currentNode = currentNode.nextNode;
        }
    }

    public static Node findLeastUsedNoed(){
        Node leastUsedNode = HEAD;
        Node currentNode = HEAD;
        while (currentNode != null){
            if (leastUsedNode.count > currentNode.count){
                leastUsedNode = currentNode;
            }
            currentNode = currentNode.nextNode;
        }
        return leastUsedNode;
    }

    public static boolean remove(Node node){
        Node currentNode = HEAD;
        while (currentNode != null){
            if (currentNode.value == node.value){
                Node pre = currentNode.preNode;
                Node next = currentNode.nextNode;
                pre.nextNode = next;
                next.preNode = pre;
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public static void main(String[] args){

    }
}
