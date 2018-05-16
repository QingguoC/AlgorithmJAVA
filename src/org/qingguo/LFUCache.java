package org.qingguo;

import java.util.HashMap;

public class LFUCache {
    public static void main(String[] args){
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1);

        System.out.println(lfu.minCount);

        lfu.put(2,2);
        System.out.println(lfu.minCount);
        System.out.println(lfu.get(1));
        lfu.put(3,3);

    }
    HashMap<Integer, DList> mapDLists;
    HashMap<Integer, DoublyListNode2> mapDNodes;
    int capacity;
    int minCount;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.mapDLists = new HashMap<>();
        this.mapDNodes = new HashMap<>();
        this.minCount = Integer.MAX_VALUE;
    }

    public int get(int key) {
        if (this.capacity < 1) return -1;
        if (!mapDNodes.containsKey(key)){
            return -1;
        }
        DoublyListNode2 curr = mapDNodes.get(key);
        DList currList = mapDLists.get(curr.count);
        curr = currList.remove(curr);
        curr.count = curr.count + 1;
        if (this.minCount == curr.count - 1 && mapDLists.get(this.minCount).size == 0){
            this.minCount++;
        }
        if (!mapDLists.containsKey(curr.count)){
            mapDLists.put(curr.count, new DList());
        }
        DList newList = mapDLists.get(curr.count);
        newList.add2Head(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if (this.capacity < 1) return;
        if (mapDNodes.containsKey(key)){
            DoublyListNode2 node = mapDNodes.get(key);
            node.val = value;
            node = mapDLists.get(node.count).remove(node);
            node.count = node.count + 1;
            if (this.minCount == node.count - 1 && mapDLists.get(this.minCount).size == 0){
                this.minCount++;
            }
            if (!mapDLists.containsKey(node.count)){
                mapDLists.put(node.count, new DList());
            }
            DList newList = mapDLists.get(node.count);
            newList.add2Head(node);
        } else {
            DoublyListNode2 newNode = new DoublyListNode2(key,value);
            newNode.count = 1;
            if (!mapDLists.containsKey(1)){
                mapDLists.put(1,new DList());
            }
            DList oneList = mapDLists.get(1);
            oneList.add2Head(newNode);
            mapDNodes.put(key,newNode);
            if (mapDNodes.size() > this.capacity){
                DList minList = mapDLists.get(this.minCount);
                DoublyListNode2 removed = minList.remove(minList.tail.prev);
                mapDNodes.remove(removed.key);
            }
            this.minCount = 1;
        }
    }
}

class DList{
    DoublyListNode2 head, tail;
    int size;
    DList(){
        this.head = new DoublyListNode2(0,0);
        this.tail = new DoublyListNode2(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }
    public DoublyListNode2 remove(DoublyListNode2 dNode){
        DoublyListNode2 pre = dNode.prev;
        DoublyListNode2 next = dNode.next;
        pre.next = next;
        next.prev = pre;
        dNode.prev = null;
        dNode.next = null;
        this.size--;
        return dNode;
    }
    public void add2Head(DoublyListNode2 dNode){
        dNode.next = this.head.next;
        dNode.next.prev = dNode;
        dNode.prev = this.head;
        this.head.next = dNode;
        this.size++;
    }

}

class DoublyListNode2{
    int val;
    int key;
    int count;
    DoublyListNode2 prev, next;
    DoublyListNode2(int key, int val){
        this.val = val;
        this.key = key;
        this.count = 0;
    }
}