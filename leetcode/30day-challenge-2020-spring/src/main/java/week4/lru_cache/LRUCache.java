package week4.lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * {@code get(key)} - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * {@code put(key, value)} - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache( 2 ); // capacity
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */
public class LRUCache {

    /* HashMap + doubly-linked list implementation */

    private final Map<Integer, CacheNode> map;
    private final int capacity;

    CacheNode head;
    CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }

        // Move to tail
        CacheNode t = map.get(key);

        removeNode(t);
        offerNode(t);

        return t.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode t = map.get(key);
            t.value = value;

            // Move to tail
            removeNode(t);
            offerNode(t);
        } else {
            if (map.size() >= capacity) {
                // Delete head
                map.remove(head.key);
                removeNode(head);
            }

            // Add to tail
            CacheNode node = new CacheNode(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    private void removeNode(CacheNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void offerNode(CacheNode node) {
        if (tail != null) {
            tail.next = node;
        }

        node.prev = tail;
        node.next = null;
        tail = node;

        if (head == null) {
            head = tail;
        }
    }

    private String display() {
        CacheNode cur = head;
        StringBuilder sb = new StringBuilder(1024);
        while (cur != null) {
            sb.append(cur.toString()).append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

    private static class CacheNode {

        int key;
        int value;

        CacheNode prev;
        CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "CacheNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}
