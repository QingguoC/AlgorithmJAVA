package org.qingguo;

import java.util.HashMap;
import java.util.List;

public class BrickWall554 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map  = new HashMap<>();

        int len = wall.size();
        int min = len;
        for(int i = 0; i < len; i++){
            List<Integer> row = wall.get(i);
            int sum = 0;
            for(int j = 0; j < row.size() - 1; j++){
                sum += row.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                min = Math.min(min, len - map.get(sum));
            }
        }
        return min;
    }
}
