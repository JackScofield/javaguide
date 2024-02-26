package laicode.DynamicProgramming;

public class LongestAscendingSubsequence {
    public static int longest1(int[] array) {
        if(array ==null || array.length==0){
            return 0;
        }
        // dp[i] = the length of longest ascending subsequence
        int[] dp = new int[array.length];
        int res = 1;
        for(int i = 0;i<array.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(array[j]<array[i]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    // ?
    public static int longest2(int[] array){
        if(array ==null || array.length==0){
            return 0;
        }
        // dp[i]: the smallest ending value of all ascending subsequences with length i
        int[] dp = new int[array.length + 1];
        int res = 1;
        dp[1] = array[0];
        for(int i =1;i<array.length;i++){
            int index = find(dp,1,res,array[i]);

            if(index == res){
                dp[++res] = array[i];
            }
            else{
                dp[index + 1] = array[i];
            }
        }
        return res;
    }

    // find the index of the largest smaller value to the target in the array
    // int[] array is ascending order
    private static int find(int[] array, int left, int right, int target){
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(array[mid] >= target){
                right = mid-1;
            }
            else{
                left = mid;
            }
        }
        for(int j = right;j>=left;j--){
            if(array[j]<target){
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args){

    }
}
