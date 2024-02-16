package org.example.DynamicProgramming;
/*
There is an array of positive integers, in which each integer represents a piece of Pizza’s size,
you and your friend take turns to pick pizza from either end of the array.
Your friend follows a simple strategy: He will always pick the larger one he could get during his turn.
The winner is the one who gets the larger total sum of all pizza. Return the max amount of pizza you can get.

Assumption: If during your friend's turn, the leftmost pizza has the same size as the rightmost pizza,
he will pick the rightmost one.
*/

public class CanIWin2 {
    public static int canWin(int[] nums) {
        // Write your solution here
        if(nums == null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = nums[i];
        }
        for(int i = 0;i<n-1;i++){
            dp[i][i+1] = Math.max(nums[i],nums[i+1]);
        }
        for(int len = 3;len<=n;len++){
            for(int i = 0;i<=n-len;i++){
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] + Math.min(dp[i+1][j-1],dp[i+2][j]),nums[j] + Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }


        return dp[0][n-1];
    }


    public static void main(String[] args){
        int[] array = new int[]{18,74,89,72,90,84,63,8,2,20,99,88,5};
        System.out.println(canWin(array));
    }
}
