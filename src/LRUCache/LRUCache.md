
# Leet code 146.
[LRU Cache](https://leetcode.com/problems/lru-cache/#/description)
[LRU intro](https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU)

```java
// this is an implementation of O(1) time complexity
public class LRUCache {

    public LRUCache(int capacity) {
        
    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }
}

/**
 *LRUCacheWithSingleLinkedList
 *LRUCacheWithSingleLinkedList
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
### Summary
用链表来实现URL cache 的时候，在寻找某个节点的时候是要有O(N)的时间复杂度的，可优化的地方在于
删除节点的时候。
这个问题的实现实际上是经过单链表-> 双链表-> 双链表加hashmap的过程，查询的时间复杂度依次减少。
在leetcode上面最终只有加如hashmap之后才能达到时间复杂度的要求，因为hashmap的加入，
代码既易读，而且在判断某个节点是否存在的时候不用在循环依次队列。

## Follow up:
   Could you do both operations in O(1) time complexity?
   
## other cache algo
* FIFO
* LFU