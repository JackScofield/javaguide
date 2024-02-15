package org.example.String;

public class LongestConsecutiveOnes {
    public static int longestConsecutiveOnes(int[] nums, int k) {
        // Write your solution here
        int fast=0;
        int slow=0;
        int longest=0;
        int count=0;
        while(fast<nums.length){
            if(nums[fast]== 1){
                longest = Math.max(longest,++fast-slow);
            }else if(count < k){
                count++;
                longest = Math.max(longest,++fast-slow);
            }else if(nums[slow++]==0){
                count--;
            }
        }
        return longest;
    }
}
