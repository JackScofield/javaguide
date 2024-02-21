package laicode.DynamicProgramming;

public class CutWood {
    public static int minCost(int[] cuts, int length) {
        // Write your solution here
        if(cuts == null || cuts.length == 0 || length <=0){
            return 0;
        }

        int[] helper = new int[cuts.length+2];
        int n = helper.length;
        for(int i =1;i<n-1;i++){
            helper[i] = cuts[i-1];
        }
        helper[n-1] = length;

        int[][] dp = new int[n][n];
        // len = n means cut n-1 times
        for(int len = 2; len<n;len++){
            if(len == 2){
                for(int i = 0;i<n-2;i++){
                    int j = i+2;
                    dp[i][j] = helper[j] - helper[i] + dp[i][i+1] + dp[i+1][j];
                }
            }
            else{
                for(int i = 0;i<n-len;i++){
                    dp[i][i+len] = Integer.MAX_VALUE;
                    for(int j=i+1;j<i+len;j++){
                        int cur = helper[i+len] - helper[i];
                        dp[i][i+len] = Math.min(dp[i][i+len],cur + dp[i][j] + dp[j][i+len]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args){
        int[] array1 = new int[]{3,16,19,28,37,44,47,48,51,52,62};
        int[] array2 = new int[]{2,4,7};
        int length2 = 10;
        int length1 = 67;
        int res2 = minCost(array2,length2);
        int res1 = minCost(array1,length1);
        System.out.println(res1);


    }
}
