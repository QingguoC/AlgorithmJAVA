package org.qingguo;

import java.util.*;

public class TopKFrequentWords692 {

    public List<String> topKFrequent1(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s,0) + 1);
        }
        PriorityQueue<StrCounter> heap = new PriorityQueue<>((StrCounter sc1, StrCounter sc2)-> sc1.count == sc2.count ? sc2.val.compareTo(sc1.val) : sc2.count - sc1.count);
        for(String key : map.keySet()){
            heap.add(new StrCounter(key, map.get(key)));
            if (heap.size() > k){
                heap.poll();
            }
        }
        List<String> res = new LinkedList<>();
        while (!heap.isEmpty()){
            res.add(0,heap.poll().val);
        }
        return res;
    }
    class StrCounter{
        String val;
        int count;
        StrCounter(String s, int c){
            val = s;
            count = c;
        }
    }
}
