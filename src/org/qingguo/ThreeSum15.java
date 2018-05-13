package org.qingguo;

import java.util.*;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> used = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){

                if (seen.contains(target - nums[j]) && !used.contains(target - nums[j])){

                    res.add(Arrays.asList(-target,target - nums[j],nums[j]));
                    used.add(nums[j]);
                    used.add(target - nums[j]);
                } else {
                    if(!seen.contains(nums[j]))
                        seen.add(nums[j]);
                }

            }
        }
        return res;
    }
    public List<List<Integer>> threeSum1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            HashMap<Integer,Boolean> rec = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++){

                if (rec.containsKey(target - nums[j]) && !rec.get(target - nums[j])){

                    res.add(Arrays.asList(-target,target - nums[j],nums[j]));
                    rec.put(nums[j],true);
                    rec.put(target - nums[j],true);
                } else {
                    if(!rec.containsKey(nums[j]))
                        rec.put(nums[j],false);
                }

            }
        }
        return res;
    }
}
