package org.qingguo;

//two pointers, and sum tracks the i to j sum;
public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length){
            sum += nums[j++];
            while (sum >= s){
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
