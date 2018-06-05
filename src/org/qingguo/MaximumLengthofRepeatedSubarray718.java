package org.qingguo;

public class MaximumLengthofRepeatedSubarray718 {
    //dp[i][j] is the max repeat length of sub ending at i and j, only equal at i and j counts
    //return  is max not dp last element;
    public int findLength(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;
        int max = 0;
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 1; i < aLen + 1; i++){
            for (int j = 1; j < bLen + 1; j++){

                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max;
    }
}
