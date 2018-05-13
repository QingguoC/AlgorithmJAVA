package org.qingguo;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target){

        int closest = nums[0] + nums[1] + nums[2];
        if (closest  == target){
            return closest;
        }
        Arrays.sort(nums);
        int temp = 0;
        for (int i = 0 ; i < nums.length-2; i++){
            if (closest > target && nums[i] + nums[i+1] + nums[i+2] > closest){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int lt = i + 1;
            int rt = nums.length-1;
            while (lt < rt){
                temp = nums[i] + nums[lt] + nums[rt];
                if (Math.abs(temp - target) < Math.abs(closest - target)){
                    closest = temp;
                }
                if (temp > target){
                    rt--;
                }else if(temp < target){
                    lt++;
                } else {
                    return temp;
                }

            }
        }

        return closest;
    }
}
