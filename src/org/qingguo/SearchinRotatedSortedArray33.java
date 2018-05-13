package org.qingguo;

public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        if (target < nums[0] && target > nums[nums.length - 1] ) {
            return -1;
        }
        if (nums[0] == target){
            return 0;
        }
        if (nums[nums.length - 1] == target){
            return nums.length - 1;
        }
        if (nums.length == 1){
            return -1;
        }
        boolean gt0 = target > nums[0];
        int lf, rt, md;
        lf = 0;
        rt = nums.length - 1;
        md = 0;
        while (lf < rt){
            md = (lf + rt)/2;
            if (nums[md] == target){
                return md;
            }
            if (nums[md] >= nums[0]){
                if (nums[md] > target && gt0){
                    rt = md;
                } else {
                    lf = md + 1;
                }
            } else{
                if (nums[md] < target && !gt0){
                    lf = md + 1;
                } else {
                    rt = md;
                }
            }
        }
        return -1;
    }
}
