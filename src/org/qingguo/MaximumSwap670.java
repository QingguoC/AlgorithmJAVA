package org.qingguo;

public class MaximumSwap670 {
    public int maximumSwap(int num) {
        char[] nums = ("" + num).toCharArray();
        int desc = 0;
        while (desc + 1 < nums.length){
            if (nums[desc] >= nums[desc + 1]){
                desc++;
            } else {
                break;
            }
        }
        if (desc == nums.length - 1){
            return num;
        }
        char maxR = '0';
        int maxRId = desc;
        for (int i = desc + 1; i < nums.length; i++ ){
            if (nums[i] >= maxR){
                maxR = nums[i];
                maxRId = i;
            }
        }
        for(int i = 0; i <= desc; i++){
            if (nums[i] < maxR){
                char temp = nums[i];
                nums[i] = maxR;
                nums[maxRId] = temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(nums));
    }
}
