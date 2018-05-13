package org.qingguo;

import java.util.HashMap;

public class LRUCache146 {
    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }

}
class LRUCache {
    HashMap<Integer,DoublyListNode> map;
    int capacity;
    DoublyListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DoublyListNode(0,0);
        this.tail = new DoublyListNode(0,0);
        head.next =  tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        DoublyListNode node = map.get(key);
        if (head.next != node) {
            removeNode(node);
            putFront(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        DoublyListNode node;
        if(map.containsKey(key)){
            node = removeNode(map.get(key));
            node.val = value;

        } else{
            if (map.size() >= capacity){
                DoublyListNode removed = removeNode(tail.prev);
                map.remove(removed.key);
            }
            node = new DoublyListNode(key,value);
        }

        putFront(node);
        map.put(key,node);
    }
    private DoublyListNode removeNode(DoublyListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }
    private void putFront(DoublyListNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }
}
class DoublyListNode{
    int val;
    int key;
    DoublyListNode prev, next;
    DoublyListNode(int key, int val){
        this.val = val;
        this.key = key;
    }
}