package org.qingguo;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args){
        int[] nums = new int[] {1,2,3};
        Subsets78 st = new Subsets78();
        System.out.print(st.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,res,new ArrayList<>(),0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int currId){
        if (currId == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums,res,path,currId + 1);
        path.add(nums[currId]);
        dfs(nums,res,path,currId + 1);
        path.remove(path.size() -1);
    }
}
