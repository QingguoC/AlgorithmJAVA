package org.qingguo;

public class PivotIndex724 {
    public int pivotIndex(int[] nums){
        int sumL = 0;
        int sumR = 0;
        for (int i = 0; i < nums.length; i++){
            sumR += nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            sumR -= nums[i];
            if (sumL == sumR){
                return i;
            }
            sumL += nums[i];
        }
        return -1;
    }
}
